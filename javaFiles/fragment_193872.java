while(position > 1 && head.next!=null){ //0 is replaced by 1 here
    head = head.next;
    position -= 1;
}

newNode.next = head.next;
head.next = newNode;
return first;