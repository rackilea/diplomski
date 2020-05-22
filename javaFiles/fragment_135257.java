public class Test<T,U> {
    public static <A,B> void main(String[] args) { … }
    private T operate(MyGen choice, U... args) { … }
    interface MyGen<X,Y> {
        public X asYouWish(Y... args);
    }
}