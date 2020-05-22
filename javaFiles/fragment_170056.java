public class Foo {
    static {     
        ture = 9;   
    }

    static int ture;

    {   // instance block   
        System.out.println(":"+ture+":");

    }

    public static final void main(String[] args) {
        new Foo();
    }
}