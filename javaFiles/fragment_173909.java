public static void main(String... args) throws Exception {
    ParentClass p = new ParentClass("A", "B", Arrays.asList(
            new Item(LocalDateTime.parse("2016-03-25T20:00:00"), 1.17),
            new Item(LocalDateTime.parse("2016-03-25T21:00:00"), 1.15)));

    JAXBContext jaxbContext = JAXBContext.newInstance(ParentClass.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(p, System.out);
}