public boolean twoTogether(){
    currentNode = head;
    while (currentNode.hasNext()){ 
        if (currentNode.data != currentNode.next.data){ 
            currentNode = currentNode.next;
        }
        else if (currentNode.data == currentNode.next.data){
            return True;
        }
    }
    return False;
}