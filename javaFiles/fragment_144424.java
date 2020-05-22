Document doc = new SAXBuilder().build(new File("CANDELA.xml"));
List<Element> list = doc.getRootElement()
        .getChild("ECUDOC")
        .getChild("ECU")
        .getChild("VAR")
        .getChild("DIAGCLASS")
        .getChildren("DIAGINST");
System.out.println(list.size() + " DIAGINST nodes");

for (Element node : list) {
    System.out.println(node.getAttribute("id").getValue()
            + " = " + node.getChildText("QUAL"));
}