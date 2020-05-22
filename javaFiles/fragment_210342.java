public class ListComboBoxModel<E> extends AbstractListModel<E> implements MutableComboBoxModel<E> {

    private List<E> values;
    private Object selectedItem;

    public ListComboBoxModel() {
        this.values = new ArrayList<>(25);
    }

    public ListComboBoxModel(List<E> values) {
        this.values = new ArrayList<>(values);
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public E getElementAt(int index) {
        return values.get(index);
    }

    @Override
    public void addElement(E item) {
        values.add(item);
    }

    @Override
    public void removeElement(Object obj) {
        values.remove((E)obj);
    }

    @Override
    public void insertElementAt(E item, int index) {
        values.add(index, item);
    }

    @Override
    public void removeElementAt(int index) {
        values.remove(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

}