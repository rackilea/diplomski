protected static <T> T unmarshall(String xml, Class<T> clazz)
        throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(clazz);
    Unmarshaller unmarshaller = jc.createUnmarshaller();
    T obj = clazz.cast(unmarshaller.unmarshal(new StringReader(xml)));
    return obj;
}