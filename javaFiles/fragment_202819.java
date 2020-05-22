public class WrapperClass<C extends Control> {

    private Item item ;
    private C control ;

    private Function<C, Observable> valueFunction ;

    public WrapperClass(Item item, C control, Function<C, Observable> valueFunction) { 
        this.item = item ;
        this.control = control ;
        this.valueFunction = valueFunction ;
    }

    public Observable observableValue() {
        return valueFunction.apply(control);
    }
}