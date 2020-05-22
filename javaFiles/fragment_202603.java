public static void dumpAllNodes( String path ) throws Exception {
    DocumentBuilder parser = 
      DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = parser.parse(new File(path));
    NodeList nodes = doc.getElementsByTagNameNS( "*", "*" );
    for( int i = 0; i < nodes.getLength(); i++ ){
        Node node = nodes.item( i );
        System.out.println( node.getNodeType() + " " + node.getNodeName() );
    }
}