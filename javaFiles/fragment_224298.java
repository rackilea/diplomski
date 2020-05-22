package ws.avail;

import java.io.StringWriter;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        OTAHotelAvailNotifRQ rootElement = new OTAHotelAvailNotifRQ();
        StringWriter stringWriter = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(rootElement.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(rootElement, stringWriter);
        System.out.println(stringWriter.toString());
    }

}