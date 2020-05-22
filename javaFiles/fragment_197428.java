import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(XMLXx.class);

        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("input.xml"));
        xsr = new SiteStreamReaderDelegate(xsr);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        XMLXx object = (XMLXx) unmarshaller.unmarshal(xsr);
        System.out.println(object.getSites().size());

    }

    private static class SiteStreamReaderDelegate extends StreamReaderDelegate {

        public SiteStreamReaderDelegate(XMLStreamReader xsr) {
            super(xsr);
        }

        @Override
        public String getLocalName() {
            String localName = super.getLocalName();
            if(localName.startsWith("s")) {
                return "s";
            }
            return localName;
        }

    }
}