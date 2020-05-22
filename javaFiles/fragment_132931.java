public class LimitedHashSet<E> extends HashSet<E>{

    @Override
    public boolean add(E e) {
        boolean result = super.add(e);
        checkSize();
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = super.addAll(c);
        checkSize();
        return result;
    }

    private void checkSize() {
        if (size() > 1024){
            throw new Error("LimitedHashSetError");
        }
    }
}