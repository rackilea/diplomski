public static void main(String[] args) throws DocumentException {

    SAXReader reader = new SAXReader();
    String xml = "<div class=\"discussionThread dt\"><div class=\"dt_subject\">2011 IS HERE!</div></div>";
    Document document = reader.read(new StringReader(xml));

    DefaultElement newElement = new DefaultElement("div");
    newElement.addAttribute("class", "test");
    newElement.add(new DefaultText("Test Val"));

    List content = document.getRootElement().content();
    if (content != null ) {
        content.add(0, newElement);
    }

    System.out.println(document.asXML());
}