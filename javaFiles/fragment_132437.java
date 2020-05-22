public class FirstClass<O> {
    Class<O> type;

    public static <O> FirstClass<O> create(Class<O> type) {
        return new FirstClass<O>(type);
    }

    public FirstClass(Class<O> type) {
        this.type = type;
    }

    public void routine(int size /*, other params */ ) {
        SecondClass<O> instance = new SecondClass<O>(type, size);
    }
}

public class SecondClass<O> {
    public O[] array;

    @SuppressWarnings("unchecked")
    public SecondClass(Class<O> type,int size) {
        array = (O[])Array.newInstance(type,size);
    }
}