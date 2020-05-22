import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Test {
    public static void main(String[] args) throws Exception {
        String xml = "<Employee>\r\n" +
                     "<Employee>\r\n" +
                     "    <Id>2</Id>\r\n" +
                     "    <Name>idk</Name>\r\n" +
                     "</Employee>\r\n" +
                     "</Employee>\r\n";
        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeInformation.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        EmployeeInformation empInfo = (EmployeeInformation)unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(empInfo);
    }
}
@XmlRootElement(name="Employee")
class EmployeeInformation {

    private List<EmployeeInformationElement> elements;

    @XmlElement(name="Employee")
    public List<EmployeeInformationElement> getElements() {
        return elements;
    }
    public void setElements(List<EmployeeInformationElement> elements) {
        this.elements = elements;
    }
}
class EmployeeInformationElement {

    private int id;
    private String name;

    @XmlElement(name="Id")
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name="Name")
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}