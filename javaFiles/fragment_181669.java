public class MyList extends ArrayList<Object> {

    public MyList() {
        super();
    }

    public MyList(int initialSize) {
        super(initialSize);
    }

    @Override
    public void add(Object obj) {
        if ((obj instanceof String) || (obj instanceof SomeType)) {
            add(obj);
        } else {
            throw new IllegalArgumentException("not a String or SomeType");
        }
    }

    public void add(String s) {
        super.add(s);
    }

    public void add(SomeType s) {
        super.add(s);
    }
}