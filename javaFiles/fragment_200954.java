InputStream is = null;
HttpURLConnection con = null;

try {
    URL url1 = new URL("http://www.boi.org.il/currency.xml");
    con = (HttpURLConnection)url1.openConnection();
    con.setRequestMethod("GET");
    con.connect();
    is = con.getInputStream();
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(is);
    NodeList lastVld = doc.getElementsByTagName("LAST_UPDATE");

    Element elem = (Element) lastVld.item(0);
    String lastV = elem.getTextContent();
    System.out.println(lastV);
} catch (Exception e) {
    e.printStackTrace();
}