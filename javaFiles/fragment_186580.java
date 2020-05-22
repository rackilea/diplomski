public void addNode(node front ,int number){
    node tail;
    if(isListEmpty(front)){
        //assigns a value to the member variable "front" of your node instance
        this.front = makeNode(number); 
    } 
    else {
        tail = findTail(front);
        tail.next = makeNode(number);
    }
}