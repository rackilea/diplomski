public Node findNode()
{   
    Node node = nodeList.getHead(); // get the head of the list
    Node prev = null;               // stores the previous node


    while(node != null)
    {   
        if(prev != null && prev.getKey() > node.getKey())
        {
            Node maxNode = prev;
        }

        // store node as prev and get the next node
        prev = node;
        node = node.getNext();
     }

return maxNode;