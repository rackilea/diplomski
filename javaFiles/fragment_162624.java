abstract class B<T> extends A<T> { }

class C extends B<String> {

    @Override
    String foo() {
        return "foo";
    }
}