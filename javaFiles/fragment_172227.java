public class MappableList<E> {

    private final List<E> list;

    public MappableList(E... numbers) {

        list = new ArrayList<E>();

        for (E i : numbers) {
            list.add(i);
        }
    }
}