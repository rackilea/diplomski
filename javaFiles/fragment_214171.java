import java.util.*;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(User.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/forum17047306/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        List<User> users = new ArrayList<User>();
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        while(xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
            if(xsr.isStartElement() && "User".equals(xsr.getLocalName())) {
                User user = (User) unmarshaller.unmarshal(xsr);
                users.add(user);
            }
            xsr.next();
        }
        System.out.println(users.size());
    }

}