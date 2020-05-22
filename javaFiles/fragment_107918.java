import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

    // parse input XML file into Document
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("C://Temp/xx.xml");

    // build a formatted XML String 
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    StreamResult result = new StreamResult(new StringWriter());
    transformer.transform(new DOMSource(doc), result);
    String xmlString = result.getWriter().toString();

    // Split the formatted-XML-String according to new-line
    String lines[] = xmlString.split("\\r?\\n");
    // rebuild the String, skipping undesired lines
    xmlString = "" ;
    String newLine = String.format("%n");
    for (int i = 2 ; i < lines.length-1 ; i++) {
        xmlString += lines[i] + newLine;
    }
    System.out.println(xmlString);