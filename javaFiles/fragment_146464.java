import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;


public class HTMLDocumentTest {

    private final static int P_ELEMENT_NUM = 3;

    public static void main(String[] args) //I'm throwing all my exceptions here to shorten the example, but obviously you should handle them appropriately.
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassCastException, IOException {

        Document htmlDoc = MyHTMLDocumentImpl.makeBasicHtmlDoc("My Title");

        //populate the html doc with some example content
        Element bodyElement = (Element) htmlDoc.getElementsByTagName("body").item(0);
        for(int i = 0; i < P_ELEMENT_NUM; ++i) {
            Element pElement = htmlDoc.createElement("p");
            String id = Integer.toString(i+1);
            pElement.setAttribute("id", "anId"+id);
            pElement.setTextContent("Here is some text"+id+".");
            bodyElement.appendChild(pElement);
        }

        //get the title element in a case insensitive manner.
        NodeList titleNodeList = htmlDoc.getElementsByTagName("tItLe");
        for(int i = 0; i < titleNodeList.getLength(); ++i)
            System.out.println(titleNodeList.item(i).getTextContent());

        System.out.println();

        {//get all p elements searching with lowercase
            NodeList pNodeList = htmlDoc.getElementsByTagName("p");
            for(int i = 0; i < pNodeList.getLength(); ++i) {
                System.out.println(pNodeList.item(i).getTextContent());
            }
        }

        System.out.println();

        {//get all p elements searching with uppercase
            NodeList pNodeList = htmlDoc.getElementsByTagName("P");
            for(int i = 0; i < pNodeList.getLength(); ++i) {
                System.out.println(pNodeList.item(i).getTextContent());
            }
        }

        System.out.println();

        //to serialize
        DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
        DOMImplementationLS domImplLS = (DOMImplementationLS) registry.getDOMImplementation("LS");

        LSSerializer lsSerializer = domImplLS.createLSSerializer();
        DOMConfiguration domConfig = lsSerializer.getDomConfig();
        domConfig.setParameter("format-pretty-print", true);  //if you want it pretty and indented

        LSOutput lsOutput = domImplLS.createLSOutput();
        lsOutput.setEncoding("UTF-8");

        //to write to file
        try (OutputStream os = new FileOutputStream(new File("myFile.html"))) {
            lsOutput.setByteStream(os);
            lsSerializer.write(htmlDoc, lsOutput);
        }

        //to print to screen
        System.out.println(lsSerializer.writeToString(htmlDoc)); 
    }

}