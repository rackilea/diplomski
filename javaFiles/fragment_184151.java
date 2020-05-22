@Component
public class FooDeserializer {

    private final XStream xStream;

    public FooDeserializer() {
        xStream = new XStream();
        xStream.aliasField("money", PurchaseOrder.class, "cash");
    }

    public Foo xmlToFoo(String xml) {
        return (Foo) xStream.fromXML(xml);
    }

}