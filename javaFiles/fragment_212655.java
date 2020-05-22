function scrape(doc, url, extras) {
    url = url.replace(/[?#].*/, "");
    var doi = url.match(/10\.[^?#]+/)[0];
    var citationurl = url.replace(replURLRegExp, "/action/showCitFormats?doi=");

    //TESTING
    var affiliations = [];
    var affiliation = doc.getElementsByClassName('listGroup');    


    var abstract = doc.getElementsByClassName('abstractSection')[0];

    var tags = ZU.xpath(doc, '//p[@class="fulltext"]//a[contains(@href, "keyword") or contains(@href, "Keyword=")]');

    Z.debug("Citation URL: " + citationurl);

    ZU.processDocuments(citationurl, function(citationDoc){
            var filename = citationDoc.evaluate('//form//input[@name="downloadFileName"]', citationDoc, null, XPathResult.ANY_TYPE, null).iterateNext().value;
            Z.debug("Filename: " + filename);
            var get = '/action/downloadCitation';
            var post = 'doi=' + doi + '&downloadFileName=' + filename + '&format=ris&direct=true&include=cit';

            ZU.doPost(get, post, function (text) {
                    //Z.debug(text);
                    var translator = Zotero.loadTranslator("import");

                    // Calling the RIS translator
                    translator.setTranslator("32d59d2d-b65a-4da4-b0a3-bdd3cfb979e7");
                    translator.setString(text);
                    translator.setHandler("itemDone", function (obj, item) {

                            // Sometimes we get titles and authros in all caps
                            item.title = fixCase(item.title);

                            for (var i=0; i<item.creators.length; i++) {
                                    item.creators[i].lastName = fixCase(item.creators[i].lastName, true);

                                    if (item.creators[i].firstName) {
                                            item.creators[i].firstName = fixCase(item.creators[i].firstName, true);

                                    }
                            }

                            item.url = url;
                            //for Emerald, get rid of the "null" that they add at the end of every title:
                            if (url.indexOf("www.emeraldinsight.com")!=-1){
                                    item.title = item.title.replace(/null$/, "")
                            }
                            item.notes = [];
                            for (var i in tags){
                                    item.tags.push(tags[i].textContent)
                            }

                            if (abstract) {
                                    // Drop "Abstract" prefix
                                    // This is not excellent, since some abstracts could
                                    // conceivably begin with the word "abstract"
                                    item.abstractNote = abstract.textContent
                                            .replace(/^\s*abstract\s*/i, '');
                            }

                            item.attachments = [];
                            if (extras.pdf) {
                                    item.attachments.push({
                                            url: extras.pdf,
                                            title: "Full Text PDF",
                                            mimeType: "application/pdf"
                                    });
                            }

                            item.attachments.push({
                                    document: doc,
                                    title: "Snapshot",
                                    mimeType: "text/html"
                            });
                            item.libraryCatalog = url.replace(/^https?:\/\/(?:www\.)?/, '')
                                    .replace(/[\/:].*/, '') + " (Atypon)";


                            //Affiliations 
                            for (i=0; i<affiliations.length; i++)
                            {
                                    affiliation.push(affiliations[i].textContent)
                            }
                            item.extra = affiliation.join("; ");


                            item.complete();
                    });
                    translator.translate();
            });
    })