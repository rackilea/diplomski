[...]
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
[...]
DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

//New Document
Document doc = docBuilder.newDocument();

// root element
Element rootElement = doc.createElement("object");
doc.appendChild(rootElement);

Element child = doc.createElement("object");
doc.appendChild(rootElement);

// key element
Element key = doc.createElement("key");
key.appendChild(doc.createTextNode("key1"));
child.appendChild(key);

// value element
Element value = doc.createElement("value");
value.appendChild(doc.createTextNode("value1"));
child.appendChild(value);