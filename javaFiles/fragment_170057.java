public class Parent {
    public static Parent createParentWithDefaultChild() {
        Parent p = new Parent();
        p.addChild(new Child());
        return p;
    }
    // ...
}