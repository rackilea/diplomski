public void addNode(node front ,int number){
    node tail;
    if(isListEmpty(front)){
        front = makeNode(number); //reassigns the node front parameter
    } 
    else {
        tail = findTail(front);
        tail.next = makeNode(number);
    }
}