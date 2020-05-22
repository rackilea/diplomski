//add function
public void add(Node<GameEntry> score) {
    // adding is where you now want to keep everything sorted. so I highly
    // recommend that you implement `Comparable` as I mentioned above. if not,
    // you have to put the logic in here.

    Node<GameEntry> currentNode = highScored.getFirst();
    Node<GameEntry> prevNode = null;

    // if the list is empty, or the new node must go in before the head,
    // simply add it as the head.
    if (highScores.size() == 0 || score.compareTo(currentNode) < 0) {
        highScores.addFirst(score);
    }

    // search for the position of the new node. while the node has a higher score
    // than the current node, we need to continue on so we can place it in the
    // correct place.
    while (currentNode != null && currentNode.compareTo(score) > 0) {
        prevNode = currentNode;
        currentNode = currentNode.getNext();
    }

    // if the currentNode is null, it means it is the highest score, so
    // we can simply add it to the end
    if (currentNode == null) {
        highScores.addLast(score);
    } else {
        // otherwise just add it after the correct node
        highScores.addAfter(prevNode, score);
    }
}


//remove function
public void remove(Node<GameEntry> score) {
    // removing an element should be as described above. if you keep
    // your list sorted during the ADD method, removing any element
    // should not break the order.

    // find the element - removal from a linked list is O(n),
    // since we need to know what the element BEFORE the one
    // is that you want to remove. assuming you have implemented
    // the equals method to check equality of nodes:

    Node<GameEntry> currentNode = highScores.getFirst();
    Node<GameEntry> prevNode = null;
    while (currentNode != null && !currentNode.equals(score)) {
        prevNode = currentNode;
        currentNode = currentNode.getNext();
    }

    // if currentNode is null, the node we wanted to remove was not
    // in the list.
    if (currentNode == null) {
        System.out.println("Node not found");
        return;
    }

    // now, we need to check if there is a node after the one we want
    // to remove.
    if (prevNode.getNext().getNext() != null) {
        // if there is, we follow the logic from the pseudo code
        prevNode.setNext(prev.getNext().getNext());
    } else {
        // if not, we only need to remove the last entry (since the
        // one we want to remove is the last one)
        highScores.removeLast();
    }
}