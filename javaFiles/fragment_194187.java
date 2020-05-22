if (nodeX > 0)
    adjacentNodes.add(new Node(nodeX - 1, nodeY));
if (nodeX < enterGraph.length - 1)
    adjacentNodes.add(new Node(nodeX + 1, nodeY));
if (nodeY > 0)
    adjacentNodes.add(new Node(nodeX, nodeY - 1));
if (nodeY < enterGraph[nodeX].length - 1)
    adjacentNodes.add(new Node(nodeX, nodeY + 1));