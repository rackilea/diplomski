import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource("src/forum22284324/input.xml"));
        xsr = xif.createFilteredReader(xsr, new StreamFilter() {

            @Override
            public boolean accept(XMLStreamReader reader) {
                if(reader.getEventType() == XMLStreamReader.CHARACTERS) {
                    return reader.getText().trim().length() > 0;
                } 
                return true;
            }

        });

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(xsr);
    }

}