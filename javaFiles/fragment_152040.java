@Override
public void remove(int index) {     
    if (index < 0) {
        throw new IndexOutOfBoundsException("Index cannot be negative");
    }
    else if (index == 0 && first != null) {
        first = null;
        last = null;            
    }        
    else {
        Node<T> curr = new Node<>("dummy", first);
        int c = 0;
        while (curr.next != null) {                 
            if (c == index) {
                curr.next = curr.next.next;
                if (curr.next == null) {
                    last = curr;
                }
                return;
            }
            curr = curr.next;
            c++;
        }
        throw new IndexOutOfBoundsException(String.valueOf(c));

}