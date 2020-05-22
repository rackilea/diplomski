package dbank.so;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.XMLConstants;


import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class SchemaGenExample {

    private final static String NS_PREFIX = "xs:";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element schemaRoot = doc.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, NS_PREFIX+"schema");
            doc.appendChild(schemaRoot);

            NameTypeElementMaker elMaker = new NameTypeElementMaker(NS_PREFIX, doc);

            Element idType = elMaker.createElement("simpleType", "idType");
            schemaRoot.appendChild(idType);
            Element idTypeRestr = elMaker.createElement("restriction");
            idTypeRestr.setAttribute("base", NS_PREFIX+"string");
            idType.appendChild(idTypeRestr);
            Element idTypeRestrPattern = elMaker.createElement("pattern");
            idTypeRestrPattern.setAttribute("value", "[0-9]{6}");
            idTypeRestr.appendChild(idTypeRestrPattern);

            Element itemType = elMaker.createElement("complexType", "itemType");
            schemaRoot.appendChild(itemType);
            Element sequence = elMaker.createElement("sequence");
            itemType.appendChild(sequence);
            Element itemIdElement = elMaker.createElement("element", "ItemId", "idType");
            sequence.appendChild(itemIdElement);
            Element itemNameElement = elMaker.createElement("element", "ItemName", NS_PREFIX+"string");
            sequence.appendChild(itemNameElement);         

            Element itemElement = elMaker.createElement("element", "Item", "itemType");
            schemaRoot.appendChild(itemElement);


            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(doc);
            //to create a file use something like this:
            transformer.transform(domSource, new StreamResult(new File("mySchema.xsd")));
            //to print to console use this:
            transformer.transform(domSource, new StreamResult(System.out));
        }
        catch (FactoryConfigurationError | ParserConfigurationException | TransformerException e) {
            //handle exception
            e.printStackTrace();
        }
    }

    /*
     * Class with methods to make it more convenient to create Element nodes with
     * namespace prefixed tagnames and with "name" and "type" attributes. 
     */
    private static class NameTypeElementMaker {
        private String nsPrefix;
        private Document doc;

        public NameTypeElementMaker(String nsPrefix, Document doc) {
            this.nsPrefix = nsPrefix;
            this.doc = doc;
        }

        public Element createElement(String elementName, String nameAttrVal, String typeAttrVal) {
            Element element = doc.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, nsPrefix+elementName);
            if(nameAttrVal != null)
                element.setAttribute("name", nameAttrVal);
            if(typeAttrVal != null)
                element.setAttribute("type", typeAttrVal);
            return element;
        }

        public Element createElement(String elementName, String nameAttrVal) {
            return createElement(elementName, nameAttrVal, null);
        }

        public Element createElement(String elementName) {
            return createElement(elementName, null, null);
        }
    }
}