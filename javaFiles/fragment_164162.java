public static void main(String[] args) throws MalformedURLException, IOException {
    Document doc = Jsoup.parse(new URL("http://www.google.com"),5000);
    Elements elems = doc.select("script");
    for (Element elem : elems)
        elem.remove();
    System.out.println(doc);

}