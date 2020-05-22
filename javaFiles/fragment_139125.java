import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Child.class);

        Child child = new Child();
        child.setParentProperty1("parentProperty1");
        child.setParentProperty2("parentProperty2");
        child.setChildProperty("childProperty");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(child, System.out);
    }
}