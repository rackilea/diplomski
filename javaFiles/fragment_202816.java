public abstract class WrapperClass {

    private Item item;
    private Control control;

    public WrapperClass(Item item, Control control) {
        this.item = item;
        this.control = control;
    }

    public abstract Observable observableValue() ;

}