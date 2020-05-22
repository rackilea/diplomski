class Test<E> {
    private Class<E> type;

    public Test(Class<E> type) {
        this.type = type;
    }

    public void unmarshall(String xmlString) {
        //...
        jaxbContext = JAXBContext.newInstance(type);
    }
}