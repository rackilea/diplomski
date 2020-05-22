public void addByAge(Node newNode) {
    if (start == null) {
        start = newNode;
    } else {
        Node headTemp = start;
        Node temp = null;
        while (headTemp.getNext() != null) {
            if (newNode.getAge() > headTemp.getAge() && temp != null) {
                temp.setNext(newNode);
                newNode.setNext(headTemp);
                break;
            } else {
                temp = headTemp;
                headTemp = temp.getNext();
            }
        }
        if (newNode.getAge() > headTemp.getAge()) {
            if (temp != null) {
                temp.setNext(newNode);
                newNode.setNext(headTemp);
            } else {
                start = newNode;
                newNode.setNext(headTemp);
            }

        } else {
            headTemp.setNext(newNode);
        }
    }
}