String cssSelector = //add your selector. from the example you include i cant get a proper selector.
Document doc = Jsoup.parse("html")
Elements elms = doc.select(cssSelector)
for(Element elm:elms){
     System.out.println("~" + elm.text() + "~")
}