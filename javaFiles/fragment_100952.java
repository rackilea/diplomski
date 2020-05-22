public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ABWrap.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            A a = new A("testA");
            B b = new B("testB");
            ABWrap abWrap = new ABWrap(Arrays.asList(a, b));
            marshaller.marshal(abWrap, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }