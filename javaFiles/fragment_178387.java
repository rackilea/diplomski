public class MyListModel<T> extends AbstractListModel<T> {

    private List<T> people;

    public MyListModel(List<T> people) {
        this.people = people;
    }

    @Override
    public int getSize() {
        return people.size();
    }

    @Override
    public T getElementAt(int index) {
        return people.get(index);
    }
}