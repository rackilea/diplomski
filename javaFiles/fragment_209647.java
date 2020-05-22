public class Components<T> extends TupleList<Class<?extends T>, String> {

    private static final long serialVersionUID = 1L;

    public void add(Class<? extends T> classe, String name) {
        this.add(new Tuple<Class<? extends T>, String>(classe, name));
    }
}