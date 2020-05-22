public class Foo {
    public void isFoo(Object obj) {
        System.out.println("object is a Foo: " + (obj instanceof Foo));
        Foo foo = (Foo) obj;
    }
}