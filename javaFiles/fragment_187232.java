public class Main {

    public static void main(String... args) {

        Case fcase = new Case();
        Meta meta = new Meta();

        meta.setLot("asd");
        meta.setPip("sdafa");
        meta.setUc("asgd4");

        fcase.setMeta(meta);
        fcase.setVersion(1);
        fcase.setId("sah34");
        fcase.setCode("code34");

        try {

//            File file = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Case.class, Meta.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//            jaxbMarshaller.marshal(fcase, file);
            jaxbMarshaller.marshal(fcase, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}