import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CreateXMLClass {

    public CreateXMLClass() {
        String xml1 = getXML1(new File("sample.xml"));
        System.out.println(xml1);

        System.out.println("");
        System.out.println("");

        String xml2 = getXML2();
        System.out.println(xml2);
    }

    // creates xml file and returns the contents
    private String getXML1(File f) {
        String data="";
        TransformerFactory transformerFactory;
        Transformer transformer;
        DOMSource source;
        StreamResult result;

        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root elements
            Document doc = docBuilder.newDocument();
            Element soapEnvelope = doc.createElement("soapenv:Envelope");
            soapEnvelope.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            soapEnvelope.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            soapEnvelope.setAttribute("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            soapEnvelope.setAttribute("xmlns:ns0", "https://ws.mycompany.com/");
            doc.appendChild(soapEnvelope);



            //elements
            Element header = doc.createElement("soapenv:Header");
            soapEnvelope.appendChild(header);

            Element soapBody = doc.createElement("soapenv:Body");
            soapEnvelope.appendChild(soapBody);

            Element ns0 = doc.createElement("ns0:SampleApplication");
            ns0.setAttribute("xmlns:ns0", "http://ws.mycompany.com");
            soapBody.appendChild(ns0);


            Element element01 = doc.createElement("Sample1");
            element01.appendChild(doc.createTextNode("value1"));
            ns0.appendChild(element01);

            Element element02 = doc.createElement("Sample2");
            element02.appendChild(doc.createTextNode("value2"));
            ns0.appendChild(element02);

            Element element03 = doc.createElement("Sample3");
            element03.appendChild(doc.createTextNode("value3"));
            ns0.appendChild(element03);



            //write the content into xml file
            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            source = new DOMSource(doc);
            result =  new StreamResult(f);
            transformer.transform(source, result);


            FileReader fr;
            fr = new FileReader(f);
            int d;

            d = fr.read();

            while (d != -1) {
                data = data +(char)d;
                d = fr.read();
            }
            fr.close();


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch(ParserConfigurationException pce){
            pce.printStackTrace();
        } catch(TransformerException tfe){
            tfe.printStackTrace();
        }

        return data;
    }                

    // creates xml and returns the content
    private String getXML2() {
        String data="";
        TransformerFactory transformerFactory;
        Transformer transformer;
        DOMSource source;
        StreamResult result;
        StringWriter writer;

        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root elements
            Document doc = docBuilder.newDocument();
            Element soapEnvelope = doc.createElement("soapenv:Envelope");
            soapEnvelope.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            soapEnvelope.setAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            soapEnvelope.setAttribute("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            soapEnvelope.setAttribute("xmlns:ns0", "https://ws.mycompany.com/");
            doc.appendChild(soapEnvelope);



            //elements
            Element header = doc.createElement("soapenv:Header");
            soapEnvelope.appendChild(header);

            Element soapBody = doc.createElement("soapenv:Body");
            soapEnvelope.appendChild(soapBody);

            Element ns0 = doc.createElement("ns0:SampleApplication");
            ns0.setAttribute("xmlns:ns0", "http://ws.mycompany.com");
            soapBody.appendChild(ns0);


            Element element01 = doc.createElement("Sample1");
            element01.appendChild(doc.createTextNode("value1"));
            ns0.appendChild(element01);

            Element element02 = doc.createElement("Sample2");
            element02.appendChild(doc.createTextNode("value2"));
            ns0.appendChild(element02);

            Element element03 = doc.createElement("Sample3");
            element03.appendChild(doc.createTextNode("value3"));
            ns0.appendChild(element03);



            writer = new StringWriter();
            result = new StreamResult(writer);

            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            source = new DOMSource(doc);
            transformer.transform(source, result);

            data =  writer.getBuffer().toString();

        } catch(ParserConfigurationException pce){
            pce.printStackTrace();
        } catch(TransformerException tfe){
            tfe.printStackTrace();
        }

        return data;
    }

    public static void main(String args[]) {
        new CreateXMLClass();
        System.exit(0);
    }                
}