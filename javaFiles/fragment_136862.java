package forum8885011;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Example.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Example example = new Example();
        example.setProp1("default1");
        example.setProp2(123);
        System.out.println(example.getProp1());
        System.out.println(example.getProp2());
        marshaller.marshal(example, System.out);

        example.setProp1("FOO");
        example.setProp2(456);
        System.out.println(example.getProp1());
        System.out.println(example.getProp2());
        marshaller.marshal(example, System.out);
    }

}