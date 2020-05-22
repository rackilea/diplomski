public interface EmployeeModel {

    public void insert(String fName, String lName, String sal);

}

public interface XMLEmployeeModel extends EmployeeModel {

    public void save(File file) throws IOException;

}

public abstract class AbstractXMLEmployeeModel implements XMLEmployeeModel {

    private Document doc;

    public AbstractXMLEmployeeModel(Document doc) {
        this.doc = doc;
    }

    public Document getDoc() {
        return doc;
    }

    @Override
    public void save(File file) throws IOException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult sr = new StreamResult(file);

            t.transform(source, sr);
        } catch (TransformerFactoryConfigurationError | TransformerException exp) {
            exp.printStackTrace();
            throw new IOException("Failed to save Employee model", exp);
        }
    }

}

public class DefaultXMLEmployeeModel extends AbstractXMLEmployeeModel {

    private int count = 0;

    public DefaultXMLEmployeeModel(Document doc) {
        super(doc);
    }

    @Override
    public void insert(String fName, String lName, String sal) {
        Document doc = getDoc();
        Element root = doc.getDocumentElement();

        Element employee = doc.createElement("Employee");
        employee.setAttribute("ID", Integer.toString(count++));
        root.appendChild(employee);

        Element firstName = doc.createElement("First_Name");
        firstName.setTextContent(fName);
        employee.appendChild(firstName);

        Element lastName = doc.createElement("Last_Name");
        lastName.setTextContent(lName);
        employee.appendChild(lastName);

        Element salary = doc.createElement("Salary");
        salary.setTextContent(sal);
        employee.appendChild(salary);
    }

}