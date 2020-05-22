public class MyTreeItem extends TreeItem {
    Object customProperty

    public void setCustomProperty(Object customProperty) {
        this.customProperty = customProperty
        TreeModificationEvent<T> ev = new TreeModificationEvent<>(valueChangedEvent(), this);
        Event.fireEvent(this, ev);
    }
}