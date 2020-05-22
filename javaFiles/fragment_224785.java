package xml.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XmlDocument {
    private Document document;

    public XmlNode parse(InputStream is) throws XmlException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(is);
            document.getDocumentElement().normalize();

            XmlNode node = new XmlNode(document.getDocumentElement());
            return node;
        } catch (ParserConfigurationException e) {
            throw new XmlException("Error in configuration of XML parser", e);
        } catch (SAXException e) {
            throw new XmlException("Error in parsing XML document", e);
        } catch (IOException e) {
            throw new XmlException("Error in reading InputStream", e);
        }
    }

    public XmlNode parse(String uri) throws XmlException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(uri);
            document.getDocumentElement().normalize();

            XmlNode node = new XmlNode(document.getDocumentElement());
            return node;
        } catch (ParserConfigurationException e) {
            throw new XmlException("Error in configuration of XML parser", e);
        } catch (SAXException e) {
            throw new XmlException("Error in parsing XML document", e);
        } catch (IOException e) {
            throw new XmlException("Error in opening URI", e);
        }
    }

    public XmlNode parse(File file) throws XmlException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(file);
            document.getDocumentElement().normalize();

            XmlNode node = new XmlNode(document.getDocumentElement());
            return node;
        } catch (ParserConfigurationException e) {
            throw new XmlException("Error in configuration of XML parser", e);
        } catch (SAXException e) {
            throw new XmlException("Error in parsing XML document", e);
        } catch (IOException e) {
            throw new XmlException("Error in opening file", e);
        }
    }

    public void write(OutputStream os, XmlNode node) throws XmlException {
        try {
            if (document == null) {
                document = createNewDocument();
            }
            document.appendChild(node.getNode());

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(os);

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            throw new XmlException("Error in configuration of XML writer", e);
        } catch (TransformerException e) {
            throw new XmlException("Error in writing XML", e);
        }
    }

    public void write(File file, XmlNode node) throws XmlException {
        try {
            if (document == null) {
                document = createNewDocument();
            }
            document.appendChild(node.getNode());

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            throw new XmlException("Error in configuration of XML writer", e);
        } catch (TransformerException e) {
            throw new XmlException("Error in writing XML", e);
        }
    }



    public void write(Writer writer, XmlNode node) throws XmlException {
        try {
            if (document == null) {
                document = createNewDocument();
            }
            document.appendChild(node.getNode());

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(writer);

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            throw new XmlException("Error in configuration of XML writer", e);
        } catch (TransformerException e) {
            throw new XmlException("Error in writing XML", e);
        }
    }

    private Document createNewDocument() throws XmlException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            return dBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            throw new XmlException("Error in configuration of XML parser", e);
        }
    }

    public XmlNode createNode(String nodeName) throws XmlException {
        if (document == null) {
            document = createNewDocument();
        }
        XmlNode node = new XmlNode(this, document.createElement(nodeName));
        return node;
    }

    XmlNode createNode(String nodeName, String nodeValue) throws XmlException {
        if (document == null) {
            document = createNewDocument();
        }
        Element node = document.createElement(nodeName);
        node.appendChild(document.createTextNode(nodeValue));

        return new XmlNode(this, node);
    }
}