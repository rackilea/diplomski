import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class SibilingParse {

    public static void main(String[] args) {
        try {
                String html = "<table width='575' border='0' cellspacing='1' cellpadding='0'>"
                                + "<tr>"
                                    + "<td width='39'><font class='texto4'>10110</font></td>"
                                    + "<td width='60'><font class='texto4'>IIND1000</font></td>"
                                    + "<td width='53'><font class='texto4'><div align='center'>1</div></font></td>"
                                    + "<td width='55'><font class='texto4'><div align='center'>3</div></font></td>"
                                    + "<td width='156'><font class='texto4'>INTROD. INGEN. INDUSTRIAL</font></td>"
                                    + "<td width='69'><font class='texto4'>100</font></td>"
                                    + "<td width='57'><font class='texto4'>100</font></td>"
                                    + "<td width='77'><font class='texto4'>0</font></td>"
                                + "</tr>"
                            + "</table>";

                //Xpath way
                System.out.println("XPATH");
                InputStream xmlStream = new ByteArrayInputStream(html.getBytes());
                DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = builderFactory.newDocumentBuilder();
                Document xmlDocument = builder.parse(xmlStream);
                XPath xPath =  XPathFactory.newInstance().newXPath();

                String expression = "/table/tr/td//*[text()='10110']//../following-sibling::td";
                NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println(nodeList.item(i).getFirstChild().getTextContent()); 
                }
                System.out.println();

                // Jsoup way
                org.jsoup.nodes.Document doc = Jsoup.parse(html);
                Elements tds = doc.select("td:contains(10110)");
                if(tds != null && tds.size() > 0){
                    for(Element td : tds.first().siblingElements()){
                        System.out.println(td.text());
                    }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }

}