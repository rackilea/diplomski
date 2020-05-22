Document doc = Jsoup.connect("http://www.dolarhoy.com/").get();
    //select div element that contains specific text and is direct descenant of body 
    Element title = doc.select("body > div:contains(PROMEDIO DE COTIZACIONES DE PIZARRAS AL PÚBLICO RELEVADAS POR)").first();
    //select next sibling element with summary
    Element summary = title.nextElementSibling();
    //select last cell with data needed
    String amount = summary.select("td").last().text();
    System.out.println(amount);


    //same as above - one-liner
    System.out.println(doc.select("body > div:contains(PROMEDIO DE COTIZACIONES DE PIZARRAS AL PÚBLICO RELEVADAS POR) + div td:last-child").text());