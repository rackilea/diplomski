public class MethodOverload {

    static void add(int a, int b) {

        System.out.println("Call 1:" + (a + b));
    }

    static void add(Long a, Long b) {

        System.out.println("Call 2:" + (a + b));
    }

    static void add(Long a, int b) {

        System.out.println("Call 3 :" + (a + b));
    }

    static void add(int a, long b) {

        System.out.println("Call 4 :" + (a + b));
    }

    public static void main(String[] args) {

        add(3, 4);
        add(3L, 4L);
        add(3L,4);
        add(3, 4L);

   }
}