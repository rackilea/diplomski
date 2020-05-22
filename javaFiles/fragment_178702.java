class Foo<T> {}
class Bar<T> {}

class Parent{}

public class Test1 
{

    public static void main(String[] args) {
        Foo<Bar<? extends Parent>> a = null;
        Foo<Bar<? extends Object>> b = a;  // does not compile
        Foo<Bar<?>> c = a;                 // does not compile
    }
}