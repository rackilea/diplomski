void cutToInteger (IntSLList L , int n){    
    IntSLList tmp =L.head;
    while( tmp != NULL && tmp.into != n ){
         tmp=tmp.next;
    }
    L.head = tmp;
}