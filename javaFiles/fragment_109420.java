Link linkCurr = head;
    Link previous = null;
    if (head != null) {
        for (int i = 0; i < size; ++i) 
        {
            if (obj.equals(linkCurr.getData()))
            {
                if (previous == null)
                {
                    head = linkCurr.getNext(); // sets 2nd position to head of list
                    size--;
                    break; 
                }
                previous.setNext(linkCurr.getNext()); // removes the node
                size--;
                break;
            }
            previous = linkCurr;
            linkCurr = linkCurr.getNext();
        }
    }