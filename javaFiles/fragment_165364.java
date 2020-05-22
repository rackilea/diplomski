package forum11666565;

import java.io.FileInputStream;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Product.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("src/forum11666565/input.xml"));
        xsr = new StreamReaderDelegate(xsr) {

            @Override
            public String getLocalName() {
                String localName = super.getLocalName();
                if(localName.startsWith("author")) {
                    return "author";
                } else {
                    return localName;
                }
            }

        };

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Product product = (Product) unmarshaller.unmarshal(xsr);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(product, System.out);
    }

}