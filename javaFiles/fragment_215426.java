public class Parent {

    private Child child;

    public Child getChild() {
        return child;
    }

    public Parent() { //Constructor
        this.child = new Child();
    }

    public class Child {
        public void foo() {
            ...
        }
    }
}