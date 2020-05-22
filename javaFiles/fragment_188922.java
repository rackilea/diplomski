import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {
    public static void main(String[] args) {

     try {
 String temp ="<employee id=\"1001\"><age>25</age><name>myemp<p>content inside tags</p></name></employee>";
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
 StringReader reader = new StringReader(temp);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employee emp = (Employee) jaxbUnmarshaller.unmarshal(reader);
        System.out.println(emp);

      } catch (JAXBException e) {
        e.printStackTrace();
      }

    }
}