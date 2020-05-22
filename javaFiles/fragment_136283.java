public static void main(String[] args) {
    try {

        File file = new File("C:\\myFile.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Root root = (Root) jaxbUnmarshaller.unmarshal(file);

        for (Foo foo : root.getFooList()) {
            System.out.println(String.format("Foo content: |%s|", foo));
        }

    } catch (JAXBException e) {
        e.printStackTrace();
    }

}