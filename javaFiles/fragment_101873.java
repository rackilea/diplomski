Document doc = Jsoup.connect("localhost.com").get();

        Elements links = doc.select("a[href]");
        for (Element link : links) {
            if (!link.text().isEmpty())
                System.out.println(link.text());

        }