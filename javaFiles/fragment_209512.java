public static <T> T unmarshal( Class<T> docClass, InputStream inputStream ) throws JAXBException, SAXException {
    String packageName = docClass.getPackage().getName();
    JAXBContext jc = JAXBContext.newInstance( packageName );
    Unmarshaller u = jc.createUnmarshaller();
    XMLValidator xmlValidator=new XMLValidator();
    xmlValidator.validateXMLToSchema(u, null);
    u.unmarshal(inputStream);
}