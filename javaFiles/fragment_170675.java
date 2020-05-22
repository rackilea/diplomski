public class JAXBContextFactory {

    private static JAXBContext jaxbContext;

    public static final JAXBContext getInstance() throws JAXBException {
        if(jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance(XML.class.getPackage().getName());
        }

        return jaxbContext;
    }

}