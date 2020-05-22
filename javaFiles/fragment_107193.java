else{ 
    //iterate to the last node
    while(current.getNext() != null) { 
    current = current.getNext(); 
    } 
    //Append the new node to the end
    current.setNext(newNode);  
}