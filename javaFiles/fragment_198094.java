Document document = Jsoup
        .connect("http://en.wiktionary.org/wiki/bicycle")
        .get();

Element bodyContent = document.select("div#bodyContent").first();

System.out.println(bodyContent.html());