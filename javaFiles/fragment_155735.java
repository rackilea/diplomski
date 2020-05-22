public static void addNode(Data data)
{
    Node newNode = new Node(data, head);
    Node previous = null;
    Node current = head; //this will be always NULL on first addNode call

    while(current != null && data.name.compareTo(current.data.name) >= 0){
        previous = current;
        current = current.next;
    }

    if(previous == null){
        head = newNode;
    }else{
        previous.next = newNode;
    }
        newNode.next = current; // how can be newNode.next is current?
        JOptionPane.showMessageDialog(null,"Book Information has been added to the inventory.");
}