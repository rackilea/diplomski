private String validUser(User user) throws JAXBException, PropertyException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(user,new File(USER_DETAILS_XML));
        marshaller.marshal(user,stringWriter);
        return stringWriter.toString();
    }
    /*
     * This method verifies and creates user error xml file
     */
    private String invalidUser(InvalidUser invalidUser) throws JAXBException,PropertyException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(InvalidUser.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(invalidUser, new File(USER_ERROR_XML));
        marshaller.marshal(invalidUser, stringWriter);
        return stringWriter.toString();
    }