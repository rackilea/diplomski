ArrayList<Node> allNodes = new ArrayList<Node>();

//Get the first node of all elements of <page>
Node pageNode = doc.getElementsByTagName("page").item(0);

getAllChildren(allNodes, pageNode);

//Now every child and child of child etc is on allNodes