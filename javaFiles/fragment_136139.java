import java.util.NoSuchElementException;

public class Cons extends List {
    private int elem;
    private List next;

    public Cons(int elem, List next) {
        this.elem = elem;
        this.next = next;
    }

    public boolean empty()
    { return false; }

    public int first()
    { return elem; }

    public int count()
    {
        try {
            if (first() > next.first()) {
                return 1 + next.count();
            }
            else return next.count();
        }
        catch (NoSuchElementException e) {
            return 0;
        }
    }
}