String url = "https://en.wikipedia.org/wiki/Windows_Server_2012";
try {
    Document document = Jsoup.connect(url).get();
    Elements elements = document.select("tr:has([href$=Software_release_life_cycle])");
    for (Element element: elements){
        System.out.println(element.text());
    }
}
catch (IOException e) {
    //exception handling
}