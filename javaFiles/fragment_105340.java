public class CircularList<T> {
    int length = 0;  // <- this field contains the number of elements that the list has.
    Element<T> first = null;

    public void add(Element<T> e){
        if (first == null){
            first = e;
            e.next = e;
            e.previous = e;
        } 
        else {
            first.previous.next = e;
            e.previous = first.previous;
            first.previous = e;
            e.next = first;
        }

        this.length++;  // <- increment each time you call add().
    }
}