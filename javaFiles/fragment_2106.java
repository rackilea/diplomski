Document doc = Jsoup.connect("http://fr.news.yahoo.com/jo-sotchi-manifestations-monde-entier-contre-loi-russe-125051858.html")
                .userAgent("Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36")
                .timeout(0).get();

Element el = doc.select("div#mediaarticlebody").first();
System.out.println(el);