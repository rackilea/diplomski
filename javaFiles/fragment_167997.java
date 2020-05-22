public class StaticDemo { // Note: same name as name of file

    static int a = 3;
    static int b = 4;

    static {
        System.out.println("Voila! Static block put into action");
    }

    static void show() {
        System.out.println("a= " + a);
        System.out.println("b= " + b);
    }

}