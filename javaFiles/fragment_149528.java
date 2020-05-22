import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;

class SaveDom 
{
    public static void main(String[] args) throws Exception
    {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><config><var-def name=\"initial_no\">3972971</var-def><var-def name=\"webpage\">asdf</var-def><cloudwhile condition=\"${i.toInt() != 500}\" index=\"i\" returnvalue=\"false\" indexstart=\"1\" upperbound=\"500\"><var-def name=\"webpage\" overwrite=\"true\"><cloudwhile condition=\"${i.toInt() != 500}\" index=\"i\" returnvalue=\"false\" indexstart=\"100\" upperbound=\"700\"></cloudwhile><try><body><http url=\"www.google.com/patents/US${initial_no.toInt()+i.toInt()}\"/></body><catch>ERROR- No content found for this patent number.</catch></try></var-def><file action=\"write\" path=\"data/${initial_no.toInt()+i.toInt()}_content.html\"><var name=\"webpage\"/></file></cloudwhile></config>";
        InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(is);

        // Write out the xml file
        // Use a Transformer for output
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty("encoding", "UTF-8");

        DOMSource source = new DOMSource(doc);
        java.io.StringWriter sw = new java.io.StringWriter();
        StreamResult _result = new StreamResult(sw);
        transformer.transform(source, _result);
        String out = sw.toString();
        System.out.println(out);
    }
}