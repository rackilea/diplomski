package xml.utils;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlNode {
    private Element node;
    private XmlDocument parent;

    XmlNode(Element node) {
        this.node = node;
        this.parent = null;
    }

    XmlNode(XmlDocument parent, Element node) {
        this.node = node;
        this.parent = parent;
    }

    Node getNode() {
        return node;
    }

        public String getNodeValue() {
            return node.getTextContent();
        }

    public XmlDocument getParent() {
        return parent;
    }

    public void setParent(XmlDocument parent) {
        this.parent = parent;
    }

    public List<XmlNode> getChildNodes() {
        List<XmlNode> list = new ArrayList<XmlNode>();
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                list.add(new XmlNode((Element) n));
            }
        }

        return list;
    }

    public XmlNode getFirstChild() {
        return getChildNodes().get(0);
    }

    public XmlNode getLastChild() {
        List<XmlNode> childs = getChildNodes();
        if (childs.size() == 0)
            return null;

        return childs.get(childs.size() - 1);
    }

    public List<XmlNode> getNodesByTagName(String tagName) {
        List<XmlNode> list = new ArrayList<XmlNode>();
        NodeList nodeList = node.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                list.add(new XmlNode((Element) n));
            }
        }

        return list;
    }

    public XmlNode getFirstNodeByTagName(String tagName) {
        return getNodesByTagName(tagName).get(0);
    }

    public String getTagValue(String tagName) throws XmlException {
        NodeList tagList = node.getElementsByTagName(tagName);
        if (tagList.getLength() == 0)
            throw new XmlException("Tag: '" + tagName + "' not present");

        NodeList nlList = tagList.item(0).getChildNodes();       
        Node nValue = (Node) nlList.item(0);

        return nValue.getNodeValue();
    }

    public String getAttributeValue(String attributeName) {
        return node.getAttribute(attributeName);
    }

    public String getNodeName() {
        return node.getTagName();
    }

    public void setAttribute(String name, String value) throws XmlException {
        if (parent == null) 
            throw new XmlException("Parent node not present.");

        node.setAttribute(name, value);
    }

    public void setTag(String name, String value) throws XmlException {
        if (parent == null) 
            throw new XmlException("Parent node not present.");

        XmlNode xmlNode = parent.createNode(name, value);
        node.appendChild(xmlNode.node);
    }

    public void addChildNode(XmlNode xmlNode) throws XmlException {
        if (parent == null) 
            throw new XmlException("Parent node not present.");

        node.appendChild(xmlNode.node);
    }

    public XmlNode addChildNode(String nodeName) throws XmlException {
        if (parent == null) 
            throw new XmlException("Parent node not present.");

        XmlNode child = parent.createNode(nodeName);
        node.appendChild(child.getNode());

        return child;
    }
}