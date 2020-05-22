class StaticDemo { // It can no longer public

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

public class StaticDemoShow { // Only one top level public class in same .java file
    public static void main() {
        StaticDemo.show();
    }
}