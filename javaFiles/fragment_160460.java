public class SizedListBox<T> extends ListBox<T> implements HasSize {
    public SizedListBox(){
        super();
    }
}

SizedListBox<Absence> lbRequests = new SizedListBox<>();
lbRequests.setWidth("100%"); // exists and works, I tested it