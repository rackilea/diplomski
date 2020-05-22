public class Test<T,U> {
    public static <T,U> void main(String[] args) { … }
    private T operate(MyGen choice, U... args) { … }
    interface MyGen<T,U> {
        public T asYouWish(U... args);
    }
}