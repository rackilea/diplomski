for (Element link : doc.select("article[itemprop=articleBody] a")) {
        String linkText = link.ownText();
        String linkURL = link.absUrl("href");
        System.out.println(
                String.format(
                        "%s[%s]", 
                        linkText,
                        linkURL));
    }