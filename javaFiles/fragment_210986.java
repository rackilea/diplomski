public static void main(String[] args) {

    LinkedList list = new LinkedList();
    list.insertFront(1);
    list.insertFront(2);
    list.insertFront(3);
    System.out.println(list.toString());
}

String toString() {
            String result = "";
            LinkedListNode current = head;
            while(current.getNext() != null){
                result += current.getData();
                if(current.getNext() != null){
                     result += ", ";
                }
                current = current.getNext();
            }
            return "List: " + result;
}