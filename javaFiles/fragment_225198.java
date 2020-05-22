public class ArrayListModified<E, T extends Collection<E>> extends ArrayList<T> {

    public Collection<E> unite() {
        Collection<E> newCollection = new ArrayList<>();

        for (Collection<E> element : this) {
            newCollection.addAll(element);
        }

        return newCollection;
    }
}