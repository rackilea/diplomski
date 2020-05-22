public class Main {
    public static void main(String... args){
        then(bar()); // Compilation Error
    }
    public static <E extends Exception> E bar() {
        return null;
    }
    public static void then(CharSequence actual) {
        System.out.println("char");
    }
}