DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

//build DOMs
Document doc1 = builder.parse(new File("file1.xml"));
Document doc2  = builder.parse(new File("file2.xml"));

//get all node_ids from doc2 and iterate
NodeList list = doc2.getElementsByTagName("node_id");
for(int i = 0 ; i< list.getLength() ; i++){

    Node n = list.item(i);

    //extract the id
    String id = n.getTextContent();

    //now get all node_id elements from doc1
    NodeList list2 = doc1.getElementsByTagName("node_"+id);
    for(int j = 0 ; j< list2.getLength() ; j++){

        Node m = list2.item(j);

        //import them into doc2
        Node imp = doc2.importNode(m,true);
        n.getParent().appendChild(imp);
    }
}

//write out the modified document to a new file
TransformerFactory tFactory = TransformerFactory.newInstance(); 
Transformer transformer = tFactory.newTransformer();
Source source = new DOMSource(doc2);
Result output = new StreamResult(new File("merged.xml"));
transformer.transform(source, output);