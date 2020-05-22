Document doc = Jsoup.connect("http://en.wikipedia.org/wiki/Boston").timeout(5000).get();

    Element intro = doc.body().select("p").first();
    while (intro.tagName().equals("p")) {
        //here you will get an Elements object which you can
        //iterate through to get the links in the intro
        System.out.println(intro.select("a"));
        intro = intro.nextElementSibling();
    }

    for (Element h2 : doc.body().select("h2")) {
        if(h2.select("span").size() == 2) {
            if (h2.select("span").get(1).text().equals("Geography")) {
                Element nextsib = h2.nextElementSibling();
                while (nextsib != null) {
                    if (nextsib.tagName().equals("p")) {
                        //here you will get an Elements object which you
                        //can iterate through to get the links in the 
                        //geography section
                        System.out.println(nextsib.select("a"));
                        nextsib = nextsib.nextElementSibling();
                    } else if (nextsib.tagName().equals("h2")) {
                        nextsib = null;
                    } else {
                        nextsib = nextsib.nextElementSibling();
                    }
                }
            }
        }
    }
}