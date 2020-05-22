public void remove(T target){
   removeAux(target,head, null);
}


public void removeAux(T target, Node current, Node previous) {
      //case base
       if(current == null)
               return;

    if (target.compareTo(current.data) == 0) {

        if (previous == null) {
          // is the head
            head = current.next;
        } else {
            //is not the head
            previous.next = current.next;
        }
        current = current.next;
        removeAux(target, current, previous); // previous doesn't change

    } else {
        removeAux(target, current.next, current);
    }
}