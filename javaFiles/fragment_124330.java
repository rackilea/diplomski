public class Generics {

    public static <T> void print(T what) {
        System.out.println(what);
    }

    public static <T extends Number> void printNumber(T what) {
        System.out.println(what);
    }

    public static void main(String[] args) {
        Arrays.stream(Generics.class.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("print"))
                .forEach(Generics::print);
    }

}