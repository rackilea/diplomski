void printList(List l){
    if ( l.empty == true ){ //the base case is when the list l is empty
        return;
    }

    print(l.head);
    printList(l.tail); 
}