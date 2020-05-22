public class Foo<T extends Comparable> {    
    T[] createArray() {
        return (T[])new Object[1];
    }

    public static void main(String... args) {
        Foo<String> foo = new Foo<>();
        String[] ss = foo.createArray(); // here
    }
}