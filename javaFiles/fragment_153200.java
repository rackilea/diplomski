public interface IList
{
    public int getNodeNumbers();
}

public class EmptyList implements IList
{
    @Override public int getNodeNumbers() {
        return 0;
    }
}

public class ConsList implements IList
{
    private Node node;

    private IList next;

    public ConsList(Node node, IList next) {
        this.node = node;
        this.next = next;
    }

    @Override public int getNodeNumbers() {
        return 1 + next.getNodeNumbers();
    }
}