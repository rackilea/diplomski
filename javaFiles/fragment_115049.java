public class Test<E extends Enum<E>> {

    private static enum MyEnum {
        FIRST,
        SECOND
    };

    private final Class<E> type;

    public Test(Class<E> type) {
        this.type = type;
    }

    public static void main(String[] args) {
        Test<MyEnum> container = new Test<>(MyEnum.class);
        System.out.println(container.type);
        System.out.println(of(MyEnum.class).type);
    }

    public static <E extends Enum<E>> Test<E> of(Class<E> type) {
        return new Test<>(type);
    }
}