import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

public class XmlUtils
{
    public static void main(String[] args) throws JDOMException, IOException {
                String test="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><address-book xmlns=\"qwerty\" xmlns:ab2=\"asdfgh\"><contact time-stamp=\"2014-02-26T16:35:20.678+02:00\" id=\"12345\"></contact><contact time-stamp=\"2014-02-26T16:37:19.370+02:00\" id=\"12346\"></contact><contact time-stamp=\"2014-02-26T16:38:53.345+02:00\" id=\"12347\"></contact><contact time-stamp=\"2014-02-26T16:37:30.828+02:00\" id=\"12348\"></contact></address-book>";
        Document document = XmlUtils.createDocument(test);
        Element rootNode=document.getRootElement();
        Namespace namespace=Namespace.getNamespace("qwerty");
        rootNode.setNamespace(namespace);
        List list = rootNode.getChildren("contact",namespace);
        for (int i = 0; i < list.size(); i++) {
              Element node = (Element) list.get(i);
              System.out.println("id values using Style 1 : " + node.getAttribute("id").getValue());
             }
        List<Element> list2 = document.getRootElement().getChildren("contact",namespace);
        for( Element ele : list2){
            System.out.println(ele.getAttribute("id").getValue());
        }
    }
public static String getFormatedXMLString(String doc)  throws JDOMException, IOException
{
    return (  makeDomToFormatedString( createDocument(doc)  ) ) ;
}

public static String makeDomToFormatedString(Document doc)
{
    return makeDomToFormatedString(doc.getRootElement());
}

public static String makeDomToFormatedString(Element elem)
{
    XMLOutputter output = new XMLOutputter();

    Format format = Format.getPrettyFormat();
    format.setExpandEmptyElements( true );
    format.setTextMode( Format.TextMode.TRIM_FULL_WHITE );

    output.setFormat( format );
    return output.outputString(elem);
}

public static Document createDocument(String xml) throws JDOMException, IOException
{
    InputSource in = new InputSource(new StringReader(xml));
    SAXBuilder saxB = new SAXBuilder();
    return ((saxB.build(in)));
}

public static Element createElement(File xmlFile) throws JDOMException, IOException
{
    SAXBuilder saxB = new SAXBuilder();
    Document document = saxB.build(xmlFile);
    return document.getRootElement();
}


public static void writeXmlFile(Document doc,String path){

    try {
        XMLOutputter xmlOutputer = new XMLOutputter();

        xmlOutputer.setFormat( Format.getPrettyFormat() );
        xmlOutputer.output( doc , new FileWriter( path ) );

    } catch (IOException e) {
      e.printStackTrace();
    }
}
}