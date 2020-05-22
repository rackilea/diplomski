import javax.xml.bind.*;
import javax.xml.bind.util.JAXBSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        // Create Input from Foo Model
        forum17791487.foo.Root fooRoot = new forum17791487.foo.Root();
        fooRoot.setValue("Hello World");
        JAXBContext fooContext = JAXBContext.newInstance(forum17791487.foo.Root.class);
        JAXBSource jaxbSource = new JAXBSource(fooContext, fooRoot);

        // Unmarshal Foo Input to Bar Model
        JAXBContext barContext = JAXBContext.newInstance(forum17791487.bar.Root.class);
        Unmarshaller unmarshaller = barContext.createUnmarshaller();
        forum17791487.bar.Root barRoot = (forum17791487.bar.Root) unmarshaller.unmarshal(jaxbSource);
        System.out.println(barRoot.getValue());
    }

}