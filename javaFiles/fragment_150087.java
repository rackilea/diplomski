public class Foo {

    private int x;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }
}

public class HelloWorld {

    public static void main(String[] args)
    {
        Foo foo = new Foo();
        foo.setX(45);

        System.out.println(foo.getX());
    }

}