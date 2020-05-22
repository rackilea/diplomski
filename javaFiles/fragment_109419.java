Link linkCurr = head;
    if (head != null) {
        for (int i = 0; i < size; ++i) {
            if (obj.equals(linkCurr.getData())){
                linkCurr.setNext(linkCurr.getNext().getNext());
                size--;
                break;
            }
            linkCurr = linkCurr.getNext();
        }
    }