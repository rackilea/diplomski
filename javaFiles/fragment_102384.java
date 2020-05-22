private ArrayList<SearchNode> closedNodes = new ArrayList<SearchNode>();
private ArrayList<SearchNode> openNodes = new ArrayList<SearchNode>();
//create the start and end nodes
SearchNode end = new SearchNode(380, 560, -1, null);
SearchNode start = new SearchNode(115,655, 0, end);


// add start node to the openSet

openNodes.Add(start);

while(openNodes.Count > 0) // while there still is a node to test
{
    // I am afraid there is another severe problem here.
    // OpenSet should be PriorityQueue like collection, not a regular Collection.
    // I suggest you to take a look at a Minimum BinaryHeap implementation. It has a logN complexity
    // of insertion and deletion and Constant Complexity access.

   // take the Node with the smallest FValue from the openSet. (With BinHeap constant time!)
    SearchNode current = openNodes.GetSmallestFvaluedNode(); // this should both retrieve and remove the node fromt he openset.

    // if it is the endNode, then we are node. The FValue (or the Gvalue as well since h value is zero here) is equal to the cost.
    if (current.EqualTo(end)) // not reference equality, you should check the x,y values
{
    return current.getfScore();
}

   //check the neighbourNodes, they may have been created in a previous iteration and already present in the OpenNodes collection. If it is the case, their G values should be compared with the currently calculated ones.
 // dont forget to check the limit values, we probably do not need nodes with negative or greater than the grid size coordinate values, I am not writing it
 // also here is the right place to check for the blocking nodes with a simple for loop I am not writing it either

  double neighbourGValue = current.getgScore() + 1;
 if (openNodes.Contains(current.getXCoordinate(), current.getYCoordinate() + 1))
  {
     // then compare the gValue of it with the current calculated value.
     SearchNode neighbour = openNodess.getNode(current.getXCoordinate(), current.getYCoordinate() + 1);
     if(neighbour.getgScore() > neighbourGValue)
        neighbour.setgScore(neighbourGValue);
  }
  else if(!closedNodes.Contains(current.getXCoordinate(), current.getYCoordinate()))
  {
      // create and add a fresh Node
     SearchNode n = new SearchNode(current.getXCoordinate(), current.getYCoordinate() + 1, neighbourGValue, endNode);
     openNodes.Add(n);
  }
  // do the same for the other sides : [x+1,y - x-1,y - x, y-1]

  // lastly add the currentNode to the CloseNodes.
  closedNodes.Add(current);
}

// if the loop is terminated without finding a result, then there is no way from the given start node to the end node.
 return -1;