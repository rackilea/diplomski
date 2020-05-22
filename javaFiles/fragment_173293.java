public class A{
    public static int b;

    public int x;
    public int doStuff(){
        return x;
    }

    public static void main(String[] args){
        System.out.println(b); //Valid. Who's b? A (the class we are in)'s b.
        System.out.println(x); //Error. Who's x? no instance provided, so we don't know.
        doStuff(); //Error. Who are we calling doStuff() on? Which instance?

        A a = new A();
        System.out.println(a.x); //Valid. Who's x? a (an instance of A)'s x.
    }
}