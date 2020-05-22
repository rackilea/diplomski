String page = flights.body();
    System.out.println(page);
    Document doc = Jsoup.parse(page);
    Elements elems = doc.select("tr.FlightTrackerListRowOdd, tr.FlightTrackerListRowEven");

    for(Element element : elems) {
        Elements childElems = element.select("td");
        String text1 =  childElems.get(0).text();
        String text2 =  childElems.get(1).text();
        System.out.println(text1 + " " + text2);
    }