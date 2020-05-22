import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Test {

    private static final String RECORD_START_TAG = "<PatientRecord>";
    private static final String RECORD_END_TAG = "</PatientRecord>";

    public static void main(String[] args) {
        File records = new File("Records.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(records))) {
            StringBuilder record = null;
            String text = null;
            while ((text = br.readLine()) != null) {

                if (text.contains("<---") && text.contains("--->")) {
                    String start = text.substring(0, text.indexOf("<---"));
                    String end = text.substring(text.indexOf("--->") + 4);
                    text = start + end;
                }

                if (text.trim().length() > 0) {
                    if (text.startsWith(RECORD_START_TAG)) {

                        record = new StringBuilder(128);
                        record.append(text);

                    } else if (text.startsWith(RECORD_END_TAG)) {

                        record.append("</Info>");
                        record.append(text);

                        try (ByteArrayInputStream bais = new ByteArrayInputStream(record.toString().getBytes())) {

                            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(bais);
                            XPath xPath = XPathFactory.newInstance().newXPath();
                            XPathExpression exp = xPath.compile("PatientRecord/Info/first_name");
                            Node firstName = (Node) exp.evaluate(doc, XPathConstants.NODE);

                            exp = xPath.compile("PatientRecord/Info/mailing_address");
                            Node address = (Node) exp.evaluate(doc, XPathConstants.NODE);

                            exp = xPath.compile("PatientRecord/Info/blood_type");
                            Node bloodType = (Node) exp.evaluate(doc, XPathConstants.NODE);

                            System.out.println(
                                    firstName.getTextContent() + ", "
                                    + address.getTextContent() + ", "
                                    + bloodType.getTextContent());

                        } catch (ParserConfigurationException | XPathExpressionException | SAXException ex) {
                            ex.printStackTrace();
                        }

                    } else {

                        record.append(text);

                    }

                }

            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

}