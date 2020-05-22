if (doc != null) {
         Elements elements = doc.select("content");
         for (int i = 0; i < elements.size(); i++) {
             Element element  = elements.get(i);
             Document doc2 = Jsoup.parse(element.text());
             Elements liElements =  doc2.select("li");
             for (Element liElemet : liElements) {
                 String strValue  = liElemet.select("a").text();
             }   
         }
     }