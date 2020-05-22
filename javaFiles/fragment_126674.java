public static void main(String[] args) throws Exception {
    XMLInputFactory factory = XMLInputFactory.newInstance();
    factory.setProperty("javax.xml.stream.isCoalescing", true);
    ReaderInputStream ris = new ReaderInputStream(new StringReader("<tag>STOXXÂ®Europe 600 Food&amp;BevNR ETF</tag>"));
    XMLStreamReader reader = factory.createXMLStreamReader(ris, "UTF-8");

    StringBuilder sb = new StringBuilder();
    while (reader.hasNext()) {
        reader.next();
        if (reader.hasText())
            sb.append(reader.getText());
    }

    System.out.println(sb);
}