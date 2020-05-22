import org.apache.xerces.dom.DocumentImpl;
import org.apache.xerces.dom.DocumentTypeImpl;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//a base class somewhere in the hierarchy implements org.w3c.dom.Document
public class MyHTMLDocumentImpl extends DocumentImpl {

    private static final long serialVersionUID = 1658286253541962623L;


    /**
     * Creates an Document with basic elements required to meet
     * the <a href="http://www.w3.org/TR/xhtml1/#strict">XHTML standards</a>.
     * <pre>
     * {@code
     * <?xml version="1.0" encoding="UTF-8"?>
     * <!DOCTYPE html 
     *     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
     *     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
     * <html xmlns="http://www.w3.org/1999/xhtml">
     *     <head>
     *         <title>My Title</title>
     *     </head>
     *     <body/>
     * </html>
     * }
     * </pre>
     * 
     * @param title desired text content for title tag. If null, no text will be added.
     * @return basic HTML Document. 
     */
    public static Document makeBasicHtmlDoc(String title) {
        Document htmlDoc = new MyHTMLDocumentImpl();
        DocumentType docType = new DocumentTypeImpl(null, "html",
                "-//W3C//DTD XHTML 1.0 Strict//EN",
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
        htmlDoc.appendChild(docType);
        Element htmlElement = htmlDoc.createElementNS("http://www.w3.org/1999/xhtml", "html");
        htmlDoc.appendChild(htmlElement);
        Element headElement = htmlDoc.createElement("head");
        htmlElement.appendChild(headElement);
        Element titleElement = htmlDoc.createElement("title");
        if(title != null)
            titleElement.setTextContent(title);
        headElement.appendChild(titleElement);
        Element bodyElement = htmlDoc.createElement("body");
        htmlElement.appendChild(bodyElement);

        return htmlDoc;
    }

    /**
     * This method will allow us to create a our
     * MyHTMLDocumentImpl from an existing Document.
     */
    public static Document createFrom(Document doc) {
        Document htmlDoc = new MyHTMLDocumentImpl();
        DocumentType originDocType = doc.getDoctype();
        if(originDocType != null) {
            DocumentType docType = new DocumentTypeImpl(null, originDocType.getName(),
                    originDocType.getPublicId(),
                    originDocType.getSystemId());
            htmlDoc.appendChild(docType);
        }
        Node docElement = doc.getDocumentElement();
        if(docElement != null) {
            Node copiedDocElement = docElement.cloneNode(true);
            htmlDoc.adoptNode(copiedDocElement);
            htmlDoc.appendChild(copiedDocElement);
        }
        return htmlDoc;
    }

    private MyHTMLDocumentImpl() {
        super();
    }

    @Override
    public Element createElement(String tagName) throws DOMException {
        return super.createElement(tagName.toLowerCase());
    }

    @Override
    public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
        return super.createElementNS(namespaceURI, qualifiedName.toLowerCase());
    }

    @Override
    public NodeList getElementsByTagName(String tagname) {
        return super.getElementsByTagName(tagname.toLowerCase());
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        return super.getElementsByTagNameNS(namespaceURI, localName.toLowerCase());
    }

    @Override
    public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
        return super.renameNode(n, namespaceURI, qualifiedName.toLowerCase());
    }
}