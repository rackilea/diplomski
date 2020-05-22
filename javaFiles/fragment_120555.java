URL url = new URL("http://www.fantagiaveno.it/goalpartita.asp");
        Document doc = Jsoup.parse(url, 3000);

        Elements elements = doc.body().select(".TitoloTabellaBlu");

        for (Element element : elements) {
            String val = element.html();
            if (val.startsWith("GOAL VITTORIA")) {                    
                Iterator<Element> ite = element.parent().parent().select("td[class=TestoTabella8]").iterator();
                ite.next(); // first one is image, skip it 
                int index = 0;

                while (ite.hasNext()) {
                    //your code here                    
                }
            } else if (val.startsWith("GOAL PAREGGIO")) {                    
                Iterator<Element> ite2 = element.parent().parent().select("td[class=TestoTabella8]").iterator();
                while (ite2.hasNext()) {

                }
            }

        }