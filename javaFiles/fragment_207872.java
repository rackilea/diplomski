String testCars = "<root><car><name>car1</name></car><other><something>Unknown</something></other><car><name>car2</name></car></root>";
XMLInputFactory factory = XMLInputFactory.newInstance();
try {
    XMLStreamReader streamReader = factory.createXMLStreamReader(new StringReader(testCars));
    streamReader.nextTag();
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer t = tf.newTransformer();
    streamReader.nextTag();
    while ( streamReader.isStartElement() ||
          ( ! streamReader.hasNext() && streamReader.nextTag() == XMLStreamConstants.START_ELEMENT)) {
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        t.transform(new StAXSource(streamReader), result);
        System.out.println( "XmlElement: " + writer.toString());
    }
} catch (Exception e) { ... }