public void moveRear(int index) {
    if (index < 1 || index > size || index == size) {//You actually have already 
                                                     //dealt with special case #2
        System.out.println("Conditions are not met");
        return;
    }
    if (head == null) {
        System.out.println("List is empty");
        return;
    }
    Node cNode = null;
    Node pNode = null;
    cNode = head;
    for (int i = 1; i < index-1; i++) {
        cNode = cNode.next;
    }
    pNode = head;
    while (pNode.next !=null){
        pNode = pNode.next;
    }
    if(index==1){ //special case #1
        head = cNode.next; //reset the front to the node after the front node
        pNode.next = cNode; //update the former rear's next field
        tail = pNode.next; //update the tail VARIABLE
    }
    else{ //what you would do if it was not either special case
        pNode.next = cNode.next;//reset the former rear's next field first
        cNode.next = cNode.next.next;//then change cNode's next field, ORDER MATTERS HERE
        tail = pNode.next;//then reset the rear VARIABLE

}