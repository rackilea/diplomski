package forum12713373;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        ObjectFactory objectFactory = new ObjectFactory();

        Foo foo = new Foo();
        foo.absent = null;
        foo.setToNull = objectFactory.createSetToNull(null);
        foo.setToValue = objectFactory.createSetToValue(false);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(foo, System.out);
    }

}