import java.util.NoSuchElementException;

public class Nil extends List {
    public boolean empty()
    { return true; }

    public int first()
    { throw new NoSuchElementException(); }

    public int count()
    {
        throw new IllegalAccessError();
    }
}