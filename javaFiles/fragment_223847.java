public String marshal() {
    JAXBContext context;
    try {
        context = JAXBContext.newInstance(FormElement.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.marshal(this, stringWriter);
        return stringWriter.toString();
    } catch (JAXBException e) {
        String mess = "Error marshalling FormElement " + e.getMessage()
                + (e.getCause() != null ? ". " + e.getCause() : " ");
        System.out.println(mess);
    }
    return null;
}