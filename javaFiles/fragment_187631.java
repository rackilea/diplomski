public boolean insert(Person p){
        ListElement element = new StackElement(p);
        boolean inserted = false;
        if(head == null){
            head = element;
            size = size + 1;
            inserted = true;
            return inserted;
        }
        ListElement temp = head;
        ListElement prev = null;
        while(temp != null){
            if(temp.compareTo(element) < 0) {
                    if(prev != null) prev.next = element; //Keep the chain connected
                    element.next = temp; //Insert you element before temp
                    inserted = true;
                    break; 
                }
                prev = temp;
                temp = temp.next;
            }
        }
        if(!inserted && temp == null && prev != null) { //You may want to insert it at the end of the list if no upper element is found.
                 prev.next = element; //Put it at the end.
                 inserted = true;
        }
       if(inserted) size = size + 1;
       return inserted; //This should be true in any case but I left it for the case you want to avoid inserting the element at the end if its place is not found.
    }