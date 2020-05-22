Document getXml(URL url) {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    URLConnection con = url.openConnection();
    try (InputStream is = con.getInputStream()) {
        return dBuilder.parse(is);
    }
}