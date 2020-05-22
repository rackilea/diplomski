public class Test1 {

    static int a = 1;
    static int b = 2;
    static int c = 3;

    public static void foo() {
        int c; // Now c is local, like in the Python
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        c = c + 1;
    }   

    public static void main(String[] args) {
        foo();
    }   
}