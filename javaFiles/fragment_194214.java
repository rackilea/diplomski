if(current.item.compareTo(e) > 0){
    Node temp = current;
    current = new Node(e, null);
    current.next = temp;
    break;
}else
    \\...