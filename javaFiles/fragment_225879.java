// get the list of customdata nodes
NodeList customDataNodeSet = findNodes(document, "//customdata" );

for (int i=0 ; i < customDataNodeSet.getLength() ; i++) {
  Node customDataNode = customDataNodeSet.item( i );

  // get the location nodes (if any) within this one customdata node
  NodeList locationNodeSet = findNodes(customDataNode, "location" );

  if (locationNodeSet.getLength() > 0) {
    // replace
    locationNodeSet.item( 0 ).setTextContent( "http://stackoverflow.com/" );
  }
  else {
    // insert
    Element newLocationNode = document.createElement( "location" );
    newLocationNode.setTextContent("http://stackoverflow.com/" );
    customDataNode.appendChild( newLocationNode );
  }
}