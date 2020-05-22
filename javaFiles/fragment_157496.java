public class MyList<T extends TestNumber> extends AbstractList<T> {

    public static <T extends TestNumber> MyList<T> newInstance(NumberType<T> type) {
        return new MyList<T>();
    }

    private MyList() {}

    // Class body omitted
}