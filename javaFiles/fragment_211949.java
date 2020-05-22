try(CloseableXmlEventReader reader = 
        new CloseableXmlEventReader(XMLInputFactory.newInstance().createXMLEventReader(new FileInputStream("test.xml")))) {

} catch (XMLStreamException | FileNotFoundException ex) {
    Logger.getLogger(CloseableXmlEventReader.class.getName()).log(Level.SEVERE, null, ex);
}