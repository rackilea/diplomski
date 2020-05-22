try {
    JAXBContext jaxbContext = JAXBContext.newInstance(fooClass.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    jaxbMarshaller.marshal(fooInstance, ps);

    String result = new String(baos.toByteArray());

    ...
} catch (JAXBException e) {
    ...
}