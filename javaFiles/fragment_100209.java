Document doc = Jsoup.connect(url).get();      

    Elements section = doc.select("#main"); //select section with the id = main
    Elements allArtTags = section.select("article"); // select all article tags in that section
    for (Element artTag : allArtTags ){
        Elements atags = artTag.select("a"); //select all a tags in each article tag
        for(Element atag : atags){
            System.out.println(atag.text()); //print the link text or 
            System.out.println(atag.attr("href"));//print link
        }
    }