public class Class<T> {
    public <V>Class(V arg) {

    }
    public static void main(String[] args) {
        new <Number>Class<Object>(0);
    }
}