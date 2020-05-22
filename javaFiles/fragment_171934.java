public class Test {

    public static void main(String[] args) throws Exception {
        // create your context, and make sure to tell it about your enum class
        JAXBContext context = JAXBContext.newInstance(new Class[]{Foo.class,MyEnum.class});
        // create the unmarshaller
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // try to unmarshal the XML into a Foo object
        Foo f = (Foo) unmarshaller.unmarshal(new File("MyXml.xml"));

        // if it worked, try to write it back out to System.out and verify everything worked!
        if ( f != null) {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(f, System.out);
        }        
    }
}