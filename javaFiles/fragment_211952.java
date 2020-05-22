private boolean addDescending(E item){
    if(head == null){ //case new list
        head = new Node<E>(item, null);
        size++;
        return true;
    } else if(head.data.compareTo(item)>0){ // case insert befor head
        head = new Node<E>(item, head);
        size++;
        return true; 
    } else {
        Node<E> p; 
        for(p = head;p.next!=null; p=p.next){//compare all except head
           if(p.next.data.compareTo(item) > 0){
              p.next = new Node<E>(item, p.next);
              size++;
              return true;
           }
         }
         //not found: insert at the end
         p.next = new Node<E>(item, null);
         size++;
         return true;
     }
}