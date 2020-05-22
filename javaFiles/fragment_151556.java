package forum8986842;

import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    private JAXBContext jc;

    public Demo() throws JAXBException {
        jc = JAXBContext.newInstance(Root.class);
    }

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        demo.demo("<Root><Item/></Root>");
        demo.demo("<Root><Item>Hello World</Item></Root>");
    }

    private void demo(String xml) throws JAXBException {
        System.out.println("\n\nINPUT:  " + xml);
        StringReader stringReader = new StringReader(xml);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(stringReader);

        System.out.println("ITEM:   " + root.getItem());

        System.out.print("OUTPUT: ");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(root, System.out);
    }

}