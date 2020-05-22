public class AlphabetToXML {
    public static void main(String[] args) {
        Alphabet alpha = new Alphabet("Apple", "Ball", "Cat", "Dog",
                "Elephant", "Fox");
        try {
            String filePath = "PATH_TO_SAVE_YOUR_FILE";
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Alphabet.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(alpha, file);
            jaxbMarshaller.marshal(alpha, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}