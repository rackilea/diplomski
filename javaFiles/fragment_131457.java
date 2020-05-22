public static void main(String[] args) throws Exception {
    String url = "https://www.openml.org/t/31";
    Document doc = Jsoup.connect(url).get();

    Element parentElement = doc.select("div#detail").first();
    Elements h2Element = parentElement.child(1).select("h2");
    System.out.println(h2Element.text());
}