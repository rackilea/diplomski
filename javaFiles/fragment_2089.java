Document document = Jsoup.connect("http://www.gbgb.org.uk/resultsRace.aspx?raceID=293047-2").get(); 
        XElements element = Xsoup.compile("//*[@id=\"content\"]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[2]/table[1]/tbody/tr/td[4]").evaluate(document);

        // Get text content
        String textContent = element.getElements().get(0).childNode(0).toString();

        // Extract time portion
        String time = textContent.trim().replaceAll("\\&nbsp\\;", " ").split("\\s+")[1];

        // Prints 11:19
        System.out.println(time);