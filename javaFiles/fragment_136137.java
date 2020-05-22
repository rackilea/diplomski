public class Cons extends RecursiveList {

    private static int result;

    private final Integer elem;
    private final RecursiveList prev;
    private final RecursiveList next;

    private Cons(Cons parent) {

        prev = parent;
        elem = incIndex() < elements.length ? elements[index] : null;
        System.out.printf("Creating new Cons with element %d(%d)%n", elem, index);
        next = elem != null ? new Cons(this) : null;
    }

    Cons() {
        this(null);
    }

    public boolean empty() {
        return false;
    }

    @Override
    public /*@Nullable*/ Integer getElement() {
        return elem;
    }

    @Override
    public int count() {

        if (elem != null)
        {
            if (prev != null && elem < prev.getElement())
                result += 1;

            if (next != null) {
                return next.count();
            }
        }
        return result;
    }
}