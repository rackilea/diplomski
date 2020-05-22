public void add(Train myTrain) {
    add(myTrain, head);
}

private void add(Train myTrain, ListNode head) {
    if (head.getNext() == null) {
        // End of list
        head.setNext(new ListNode(myTrain));
        count++;
    } else if (head.getNext().getTrain().getTrainNumber() < myTrain.getTrainNumber()) {
        // We found the spot.
        ListNode newNode = new ListNode(myTrain);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        count++;
    } else {
        // This was not the spot, try next position.
        add(myTrain, head.getNext());
    }
}


public Train delete(int trainNumber) {
    if (head == null) {
        // There is no list at all.
        return null;
    }
    return delete(trainNumber, head);
}

public Train delete(int trainNumber, ListNode currentNode) {
    if (currentNode.getNext() == null) {
        // No train found.
        return null;
    } else if (currentNode.getNext().getTrain().getTrainNumber() == trainNumber) {
        // The next train should be deleted.
        ListNode tmp = currentNode.getNext();
        currentNode.setNext(currentNode.getNext().getNext());
        return tmp.getTrain();
    } else {
        return delete(trainNumber, currentNode.getNext());
    }
}