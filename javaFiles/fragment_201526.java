public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(A.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            B b = new B("hello");
            C c = new C("hey");
            D d = new D("hi");
            List<Letter> letters = Arrays.asList(b,c,d);
            A a = new A(letters);

            marshaller.marshal(a, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }