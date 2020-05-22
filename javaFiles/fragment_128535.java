public class Main {     
    public static class Foo<T> {
        public <E> Foo(T object, E object2) {

        }
    }
    public static void main(String[] args) throws Exception {
        Foo<Integer> foo = new <String> Foo<Integer>(1, "hello");           
    }    
}