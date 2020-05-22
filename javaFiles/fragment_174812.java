public static void sortChildren(Node parent, Comparator<Node> comparator){
    NodeList children = parent.getChildNodes();
    if(children.getLength() == 0){
        return;
    }
    List<Node> nodes = new ArrayList<Node>();
    for(int i = 0 ; i < children.getLength() ; i++){
        Node n = children.item(i);
        sortChildren(n, comparator);
        nodes.add(n);
    }
    Collections.sort(nodes, Collections.reverseOrder(comparator));
    for(Node n : nodes){
        parent.appendChild(n);
    }
}

public static void main(String[] args) throws Exception {

    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("file.xml"));
    Element root = doc.getDocumentElement();

    //sort it recursively
    sortChildren(root, new DefaultNodeNameComparator());

    //print it out (for debugging)
    OutputFormat format = new OutputFormat(doc);
    format.setLineWidth(65);
    format.setIndenting(true);
    format.setIndent(2);
    Writer out = new StringWriter();
    XMLSerializer serializer = new XMLSerializer(out, format);
    serializer.serialize(doc);
    System.out.println(out.toString());
}

class DefaultNodeNameComparator implements Comparator<Node> {
    public int compare(Node arg0, Node arg1) {
        return arg0.getNodeName().compareTo(arg1.getNodeName());
    }
}