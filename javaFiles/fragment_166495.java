while (pointer-1->next!=NULL){// points to last node 
     pointer-1 = pointer-1 -> next;
     pointer-2 = pointer-2 -> next;
}

When loop ends pointer-1 points to last-node, pointer-2 points to third last

 node1-->node2-->........ ->node-l3-->node-l2-->node-last
                             ^                   ^
                             |                   |
                           pointer-2            pointer-1