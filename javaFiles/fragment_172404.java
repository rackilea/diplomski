package javaapplication10;

public class JavaApplication10 {

    public static void main(String[] args) {

        Foo foo = new Foo();
        System.out.println("Foo.dummy() = " + foo.dummy());

    }

    @Deprecated public int dummy() {
        return 42;
    }

}

class Foo extends JavaApplication10 {

    @Override public int dummy() {
        return 41;
    }

}