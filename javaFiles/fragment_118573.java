/**
 * Get the Description as a new XML document
 *
 */
public Document retrieveDescriptionAsDocument(Document sourceDocument) {

Document document;
Node tmpNode;
Document document2 = null;

try {
    // get the description node, I am just using XPath here as it is easy
    // to read, you already have a reference to the node so just continue as you
    // were doing for that, bottom line is to get a reference to the node
    tmpNode = org.apache.xpath.XPathAPI.selectSingleNode(sourceDocument,"/items/item/description");

    if (tmpNode != null) {

        // create a new empty document
        document2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        // associate the node with the original document
        sourceDocument.importNode(tmpNode, true);
        // create a document fragment from the original document
        DocumentFragment df = sourceDocument.createDocumentFragment();
        // append the node you found, to the fragment   
        df.appendChild(tmpNode);
        // create the Node to append to the new DOM
        Node importNode = document2.importNode(df,true);
        // append the fragment (as a node) to the new empty document
        Document2.appendChild(importNode);
    }
    else {
        // LOG WARNING
        yourLoggerOrWhatever.warn("retrieveContainedDocument: No data found for XPath:" + xpathP);
    }

    } catch (Exception e) {
        // LOG ERROR
        yourLoggerOrWhatever.error("Exception caught getting contained document:",e);
    }

    // return the new doc, and the caller can then output that new document, that will now just contain "<span>yes <b>no</b></span>" as text, apply an XSL or whatever
    return document2;
}