String xml = "<?item something=\"<some_element></some_element>\"?><foo></foo>";
XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new StringReader(xml));
while (reader.hasNext()) {
    final XMLEvent event = reader.nextEvent();
    System.out.println(event + " - " + event.getClass().getSimpleName());
}