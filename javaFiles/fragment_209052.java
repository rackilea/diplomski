public class Main {
    public static void main(String[] args) {  
     try {
        File file = new File("file.xml");  
        JAXBContext jaxbContext = JAXBContext.newInstance(SampleDTO.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        SampleDTO sampleDTO= (SampleDTO) jaxbUnmarshaller.unmarshal(file);  
      } catch (JAXBException e) {  
        e.printStackTrace();  
      }  
    }  
}