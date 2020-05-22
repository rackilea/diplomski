public <T extends Object> void doSomething(T param) {
    .
    .
    JAXBElement<T> jaxb = new JAXBElement<T>(new QName("uri", "local"), (Class<T>) param.getClass(), param);
    .
    .
}