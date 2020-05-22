while (str.next != null) {  // Iterate till str.next != null, as we are creating 
                            // the next node in the loop for current node str

    nextNode = new StringNode(str.next.ch, null);
    prevNode.next = nextNode;
    prevNode = nextNode;

    str = str.next;  // Move to next node.
}