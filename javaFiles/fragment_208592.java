public class JAXBParser {

    public static void main(String args[]) throws JAXBException{
        File file = new File("C:\\XMLParserDemo\\src\\Base.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Building.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Building building = (Building) jaxbUnmarshaller.unmarshal(file);
        System.out.println(building);


    }