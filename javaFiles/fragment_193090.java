public class XMLToAplhabet {
    public static void main(String[] args) {
        try {
            String filePath = "XML_FILE_PATH";
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Alphabet.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Alphabet aplha = (Alphabet) jaxbUnmarshaller.unmarshal(file);
            System.out.println(aplha);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}