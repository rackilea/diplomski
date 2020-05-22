package p;

public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.message = "hello";
        System.out.println(sub);
        System.out.println(sub.message);
    }
}