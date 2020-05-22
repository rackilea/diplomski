public ContactNode find(int index) {
        ContactNode current = head;
        while(current!=null) {
            if(index == 0)
                return current;

            //we're not there yet. Move to next node, decrement index
            current = current.getNext();
            index--;
        }
        return null;
}