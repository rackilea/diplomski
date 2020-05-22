package forum9906642;

import java.io.*;
import javax.xml.bind.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        UriAdapter uriAdapter = new UriAdapter();

        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("src/forum9906642/input.xml"));
        xsr = xif.createFilteredReader(xsr, uriAdapter);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setAdapter(uriAdapter);
        Root root = (Root) unmarshaller.unmarshal(xsr);

        for(Child child : root.getChildren()) {
            System.out.println(child.getSomeAttribute().toString());
        }

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setAdapter(uriAdapter);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}