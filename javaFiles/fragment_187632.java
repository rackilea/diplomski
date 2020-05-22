public void insert(Person p){
        ListElement element = new StackElement(p);

        if(head == null){
            head = element;
            size = size + 1;
            return;
        }

        ListElement temp = head;
        ListElement prev = null;

        boolean inserted = false;
        while(temp != null){
            if(temp.compareTo(element) < 0) {
                    if(prev != null) prev.next = element; //Keep the chain connected
                    element.next = temp; //Insert you element before temp
                    inserted = true;
                    temp = null;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
        }
        if(!inserted && prev != null)
        { 
                 prev.next = element; //Put it at the end.
        }
       size = size + 1;
    }