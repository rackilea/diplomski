public class Bar<E extends Enum<E>> {

    private final E item;

    public E getItem(){
        return item;
    }

    public Bar(final E item){
        this.item = item;
    }
}