public class Parent {
    public void alias(XStream x) {
        x.alias("Kiddie", Parent.Child.class);
    }

    private class Child {

    }
}