public boolean addItem(ListItem newItem) {
    if(this.root == null){
        this.root = newItem;
        return true;
    }
    ListItem currentItem = this.root;
    while (currentItem != null){
        int comparison = currentItem.compareTo(newItem);
        if (comparison < 0){                               // if cur < new
            newItem.setPrevious(currentItem.previous());   //   advance cur
            if (currentItem.next()!=null){
                currentItem = currentItem.next();
            } else {                                       //   if end list
                currentItem.setNext(newItem);              //     append new
                newItem.setPrevious(currentItem);
                return true;
            }
        } else if (comparison > 0){
            // new < cur, insert before, fixes made to this part
            newItem.setNext(currentItem);                  // set   new.nxt
            newItem.setPrevious(currentItem.previous());   // set   new.prv
            if (newItem.previous()!= null){                // if    new.prv != 0
                newItem.previous().setNext(newItem);       //   set new.prv.nxt
            else                                           // else
                this.root = newItem;                       //   set root
            currentItem.setPrevious(newItem);              // set   cur.prv
            return true;
        }
        return false;     // return false if duplicate
    }
}