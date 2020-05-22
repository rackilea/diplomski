public void rotateLeft() {
  if (head != null) {                       //otherwise it is empty list
    Node temp = head;
    if (head.getNext() != null) {           //otherwise it is single item list
        head = head.getNext();
    }

    Node tail;
    if (head.getNext() != null) {
        //more than 2 items in the list
        tail = head.getNext();
    } else {
        //only 2 items in the list
        tail = head;
    }
    while (tail.getNext() != null) {
        if (tail.getNext() != null) {
            tail = tail.getNext();
        }
    }
    tail.setNext(temp);
    temp.setNext(null);
  }
}

public void rotateRight() {
  if (head != null) {                       //otherwise it is empty list
    Node tail = null;
    Node current = head;

    while (current.getNext() != null) {
        tail = current;
        current = current.getNext();
    }
    if (tail != null) {             //otherwise it is single item list
        tail.setNext(null);
        current.setNext(head);
        head = current;
    }
  }
}