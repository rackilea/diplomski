public String serialize( Object aMessageDto) throws Exception
    {
        JAXBContext jaxbContext = JAXBContext.newInstance( aMessageDto.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty( Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, SCHEMA_FILE);
        StringWriter sw = new StringWriter();
        marshaller.marshal( aMessageDto, sw);
        return sw.toString();
    }