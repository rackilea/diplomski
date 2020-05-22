public class NonSafe {
    private List x;

    public Iterator getIterator() {
        return x.iterator();
    }
}