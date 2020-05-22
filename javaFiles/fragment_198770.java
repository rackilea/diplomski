public abstract class MyMotherClass<C extends AbstractItem> {

    private AbstractItem item;

    public void setItem(AbstractItem item) {
        this.item = item;
    }

    public AbstractItem getItem() {
        return this.item;
    }

}