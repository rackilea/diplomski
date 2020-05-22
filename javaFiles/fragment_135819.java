package domparserexample.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserExampleJava {

    private List<Employee> myEmpls = new ArrayList<Employee>();

    public static void main(String[] args) throws IOException, ParserConfigurationException {
        DomParserExampleJava domParser = new DomParserExampleJava();
        domParser.parseXmlFile();
    }

    private void parseXmlFile() throws IOException, ParserConfigurationException {
        // get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            // Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // parse using builder to get DOM representation of the XML file
            Document dom = db.parse("employees.xml");
            parseDocument(dom);
            printData();

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void parseDocument(Document dom) {
        // get the root element
        Element docEle = dom.getDocumentElement();

        // get a nodelist of elements
        NodeList nl = docEle.getElementsByTagName("Employee");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                // get the employee element
                Element el = (Element) nl.item(i);

                // get the Employee object
                Employee e = getEmployee(el);

                // add it to list
                myEmpls.add(e);
            }
        }
    }

    /**
     * I take an employee element and read the values in, create an Employee object and return it
     */
    private Employee getEmployee(Element empEl) {

        // for each <employee> element get text or int values of
        // name ,id, age and name
        String name = getTextValue(empEl, "Name");
        int id = getIntValue(empEl, "Id");
        int age = getIntValue(empEl, "Age");

        String type = empEl.getAttribute("type");

        // Create a new Employee with the value read from the xml nodes
        Employee e = new Employee(name, id, age, type);

        return e;
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    private int getIntValue(Element ele, String tagName) {
        // in production application you would catch the exception
        return Integer.parseInt(getTextValue(ele, tagName));
    }

    private void printData() {

        System.out.println("No of Employees '" + myEmpls.size() + "'.");

        Iterator<Employee> it = myEmpls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}