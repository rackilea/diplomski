public class TestJaxbJackson {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream is = TestJaxbJackson.class.getResourceAsStream("test.xml");
        Root root = (Root)unmarshaller.unmarshal(is);
        System.out.println(root.getHello() + " " + root.getWorld());

        ObjectMapper mapper = new ObjectMapper();
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        mapper.registerModule(module);
        mapper.writeValue(System.out, root);
    }
}