class A {
    public static int x;
}

public class Helper {

    public static void main(String[] args) {
        A someA = new A();
        A.x = 0;

        A someOtherA = new A();
        A.x = 5;

        //uncomment next line and see what happens
        //someA.x = -55;

        System.out.println("x in someA = " + someA.x);
        System.out.println("x in someOtherA = " + someOtherA.x);
        System.out.println("x in all instances of A = " + A.x);

    }
}