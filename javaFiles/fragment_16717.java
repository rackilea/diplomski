Node remove(){ 
    identify the "oldest" node as header.next. 
    Store a reference to that node so you can return it. 
    identify the "second oldest node" as header.next.next 
    change header.next to header.next.next
    return the reference to the old header.next you saved above.