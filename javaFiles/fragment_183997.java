public static void main(String[] args) {

    DocumentImpl doc1 = new DocumentImpl();
    Element root1 = doc1.createElement("root1");
    Element node1 = doc1.createElement("node1");
    doc1.appendChild(root1);
    root1.appendChild(node1);

    DocumentImpl doc2 = new DocumentImpl();
    Element root2 = doc2.createElement("root2");
    Element node2 = doc2.createElement("node2");
    doc2.appendChild(root2);
    root2.appendChild(node2);

    DocumentImpl doc3 = new DocumentImpl();
    Element root3 = doc3.createElement("root3");
    doc3.appendChild(root3);

    // root3.appendChild(root1); // Doesn't work -> DOMException
    root3.appendChild(doc3.importNode(root1, true));

    // root3.appendChild(root2); // Doesn't work -> DOMException
    root3.appendChild(doc3.importNode(root2, true));   
}