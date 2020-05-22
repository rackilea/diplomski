public class ListEngine<T> extends AbstractListModel {

    private final ArrayList<T> innerData = new ArrayList<T>();

    public ListEngine () {
    }

    @Override
    public T getElementAt(int index) {
        return innerData.get(index);
    }

    @Override
    public int size() {
        return innerData.size();
    }

}