public boolean delete(Person p){
    boolean deleted = false;
    PersonListElement current = head;
    PersonListElement prev = null;
    while(current != null && !deleted){
        if(current.getValue().compareTo(p) == 0){
            if(prev != null) 
                prev.setNext(current.getNext());
            else
                head = current.getNext();
            deleted = true;
        } else {
        prev = current;
        current = current.getNext();
       }
    }
    if(deleted) size--;
    return deleted;
}