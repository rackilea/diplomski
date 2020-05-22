// connect to URL and retrieve source code as document
    Document doc = Jsoup.connect(url).get();

    // find the link element in the article
    Element link = doc
            .select("article[itemprop=articleBody] p.interstitial-link i a")
            .first();

    // extract the link text
    String linkText = link.ownText();

    // extract the full url of the href
    // use this over link.attr("href") to avoid relative url
    String linkURL = link.absUrl("href");


    // display
    System.out.println(
            String.format(
                    "%s[%s]", 
                    linkText,
                    linkURL));