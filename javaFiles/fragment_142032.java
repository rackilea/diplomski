public static Node deleteNode(Node list, String str) {
    // I'm assuming that you are deleting the first inscance of the string
    Node temp = list;
    Node prev = list;

    while(temp != null) {
        if(temp.getData().equals(str)) {
            if(temp.getData().equals(list.getData())) {
                return list.getNext();
            }
            else {
                prev.setNext(temp.getNext());
                return list;
            }
        }
        prev = temp;
        temp = temp.getNext();
    }

    return list;
}