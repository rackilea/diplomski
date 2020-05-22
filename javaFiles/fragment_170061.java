@XmlRootElement
public class Test {

    @XmlElement
    private Demo demo;

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        demo.setValueAttr("this is the attr value");
        demo.setValueContent("this is the element content");
        Test test = new Test();
        test.demo = demo;

        JAXBContext jaxbContext = JAXBContext.newInstance(Test.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(test, System.out);
    }
}