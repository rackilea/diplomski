public class Main {

    interface Foo<T> { }

    interface SubFoo<T> extends Foo<T> { }

    static class Bar { }

    public static void main(String[] args) {

        Set<Foo<?>> arg1 = null;
        Set<SubFoo<?>> arg2 = null;
        Set<Foo<Bar>> arg3 = null;
        Set<SubFoo<Bar>> arg4 = null;

        Set<Foo<?>> inflexibleParam;
        inflexibleParam = arg1; //success
        inflexibleParam = arg2; //incompatible types
        inflexibleParam = arg3; //incompatible types
        inflexibleParam = arg4; //incompatible types

        Set<? extends Foo<?>> flexibleParam;
        flexibleParam = arg1; //success
        flexibleParam = arg2; //success
        flexibleParam = arg3; //success
        flexibleParam = arg4; //success
    }
}