public  String createRss2(List<Item> items){
    Document doc = (Document) XMLParser.createDocument();
    Element root = doc.createElement("rss");
    root.setAttribute("version", "2.0");
    doc.appendChild(root);

    Element chl = doc.createElement("channel");
    root.appendChild(chl);

    Element title = doc.createElement("title of the feed");
    title.appendChild(doc.createTextNode("sitename"));
    chl.appendChild(title);

    Element link = doc.createElement("link");
    link.appendChild(doc.createTextNode("http://mysite.com"));
    chl.appendChild(link);

    Element description = doc.createElement("description");
    description.appendChild(doc.createTextNode("some description"));
    chl.appendChild(description);

    Element lang = doc.createElement("language");
    lang.appendChild(doc.createTextNode("en"));
    chl.appendChild(lang);

    Element copyright = doc.createElement("copyright");
    copyright.appendChild(doc.createTextNode("nicolas schwarzentrub"));
    chl.appendChild(copyright);

    Element pubDate = doc.createElement("pubDate");
    pubDate.appendChild(doc.createTextNode(DateTimeFormat.getFormat("EEE, dd MMM yyyy hh:mm:ss ZZZZ").format(new Date())));
    chl.appendChild(pubDate);


    Element image = doc.createElement("image");
    Element imageUrl = doc.createElement("url");
    imageUrl.appendChild(doc.createTextNode("https://ssl.gstatic.com/gb/images/j_e6a6aca6.png"));
    Element imageTitle = doc.createElement("title");
    imageTitle.appendChild(doc.createTextNode("some title of image"));
    Element imageLink = doc.createElement("link");
    imageLink.appendChild(doc.createTextNode("http://www.google.ch/"));

    image.appendChild(imageUrl);
    image.appendChild(imageTitle);
    image.appendChild(imageLink);
    chl.appendChild(image);

    for(Item obj : items)
    {
        Element item = doc.createElement("item");

        Element itemTitle = doc.createElement("title");
        itemTitle.appendChild(doc.createTextNode(obj.getName()));
        item.appendChild(itemTitle);


        Element itemDescription = doc.createElement("description");
        itemDescription.appendChild(doc.createTextNode(obj.getText()));
        item.appendChild(itemDescription);

        Element itemLink = doc.createElement("link");
        itemLink.appendChild(doc.createTextNode(obj.getLink()));
        item.appendChild(itemLink);

        Element itemAuthor = doc.createElement("author");
        itemLink.appendChild(doc.createTextNode(obj.getAuthor()));
        item.appendChild(itemAuthor);
        //and others if needed ..
        Element itemPubDate = doc.createElement("pubDate");
        itemPubDate.appendChild(doc.createTextNode(DateTimeFormat.getFormat("EEE, dd MMM yyyy hh:mm:ss ZZZZ").format(new Date())));
        item.appendChild(itemPubDate);

        //append this item to the link element
        chl.appendChild(item);
    }


   return doc.toString();
  }