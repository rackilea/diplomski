final String html = ... // the html of your example
    Document doc = Jsoup.parse(html);

    /*
     * Selects b-tags, that are direct childs of p-tags.
     */
    for( Element element : doc.select("p > b") )
    {
        System.out.println(element);
    }