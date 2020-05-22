NodeList node = (NodeList) xPath.evaluate( "/Pearent/a", xml, XPathConstants.NODESET );

StringBuilder stringBuilder = new StringBuilder();

for ( int i = 0; i < node.getLength(); i++ ) {

    stringBuilder.append( node.item( i ).getTextContent() );    
}

System.out.println( stringBuilder.toString() );