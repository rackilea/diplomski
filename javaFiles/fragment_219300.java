import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLWriter implements XMLStreamWriter {

private XMLStreamWriter writer;

private ProxyNameSpaceContext nc = new ProxyNameSpaceContext();

public XMLWriter(XMLStreamWriter writer) throws XMLStreamException {
    super();
    this.writer = writer;
    writer.setNamespaceContext(nc);
}

@Override
public void close() throws XMLStreamException {
    writer.close();
}

@Override
public void flush() throws XMLStreamException {
    writer.flush();
}

@Override
public NamespaceContext getNamespaceContext() {
    return writer.getNamespaceContext();
}

@Override
public String getPrefix(String uri) throws XMLStreamException {
    return writer.getPrefix(uri);
}

@Override
public Object getProperty(String name) throws IllegalArgumentException {
    return writer.getProperty(name);
}

@Override
public void setDefaultNamespace(String uri) throws XMLStreamException {
    writer.setDefaultNamespace(uri);
}

@Override
public void setNamespaceContext(NamespaceContext context)
        throws XMLStreamException {
}

@Override
public void setPrefix(String prefix, String uri) throws XMLStreamException {
    writer.setPrefix(prefix, uri);
}

@Override
public void writeAttribute(String prefix, String namespaceURI,
        String localName, String value) throws XMLStreamException {
    writer.writeAttribute(prefix, namespaceURI, localName, value);
}

@Override
public void writeAttribute(String namespaceURI, String localName,
        String value) throws XMLStreamException {
    writer.writeAttribute(namespaceURI, localName, value);
}

@Override
public void writeAttribute(String localName, String value)
        throws XMLStreamException {
    writer.writeAttribute(localName, value);
}

@Override
public void writeCData(String data) throws XMLStreamException {
    writer.writeCData(data);
}

@Override
public void writeCharacters(char[] text, int start, int len)
        throws XMLStreamException {
    writer.writeCharacters(text, start, len);
}

@Override
public void writeCharacters(String text) throws XMLStreamException {
    writer.writeCharacters(text);
}

@Override
public void writeComment(String data) throws XMLStreamException {
    writer.writeComment(data);
}

@Override
public void writeDTD(String dtd) throws XMLStreamException {
    writer.writeDTD(dtd);
}

@Override
public void writeDefaultNamespace(String namespaceURI)
        throws XMLStreamException {
    writer.writeDefaultNamespace(namespaceURI);
}

@Override
public void writeEmptyElement(String prefix, String localName,
        String namespaceURI) throws XMLStreamException {
    writer.writeEmptyElement(prefix, localName, namespaceURI);
}

@Override
public void writeEmptyElement(String namespaceURI, String localName)
        throws XMLStreamException {
    writer.writeEmptyElement(namespaceURI, localName);
}

@Override
public void writeEmptyElement(String localName) throws XMLStreamException {
    writer.writeEmptyElement(localName);
}

@Override
public void writeEndDocument() throws XMLStreamException {
    writer.writeEndDocument();
}

@Override
public void writeEndElement() throws XMLStreamException {
    writer.writeEndElement();
}

@Override
public void writeEntityRef(String name) throws XMLStreamException {
    writer.writeEntityRef(name);
}

@Override
public void writeNamespace(String prefix, String namespaceURI)
        throws XMLStreamException {
    writer.writeNamespace(prefix, namespaceURI);
}

@Override
public void writeProcessingInstruction(String target, String data)
        throws XMLStreamException {
    writer.writeProcessingInstruction(target, data);
}

@Override
public void writeProcessingInstruction(String target)
        throws XMLStreamException {
    writer.writeProcessingInstruction(target);
}

@Override
public void writeStartDocument() throws XMLStreamException {
    writer.writeStartDocument();
}

@Override
public void writeStartDocument(String encoding, String version)
        throws XMLStreamException {
    writer.writeStartDocument(encoding, version);
}

@Override
public void writeStartDocument(String version) throws XMLStreamException {
    writer.writeStartDocument(version);
}

@Override
public void writeStartElement(String prefix, String localName,
        String namespaceURI) throws XMLStreamException {
    writer.writeStartElement("", localName, namespaceURI);
    if(null != namespaceURI && namespaceURI.length() > 0) {
        String currentDefaultNS = nc.getNamespaceURI("");
        if(!namespaceURI.equals(currentDefaultNS)) {
            writeDefaultNamespace(namespaceURI);
            nc.setDefaultNS(namespaceURI);
        }
    }
}

@Override
public void writeStartElement(String namespaceURI, String localName)
        throws XMLStreamException {
    writer.writeStartElement(namespaceURI, localName);
}

@Override
public void writeStartElement(String localName) throws XMLStreamException {
    writer.writeStartElement(localName);
}

public static class ProxyNameSpaceContext implements NamespaceContext {

    private String defaultNS = "";

    public void setDefaultNS(String ns) {
        defaultNS = ns;
    }

    @Override
    public String getNamespaceURI(String prefix) {
        if("".equals(prefix)) {
            return defaultNS;
        }
        return null;
    }

    @Override
    public String getPrefix(String namespaceURI) {
        return "";
    }

    @Override
    public Iterator<?> getPrefixes(String namespaceURI) {
        return null;
    }

}

}