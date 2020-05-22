public class Parent {

    public void canSpeak() {
        System.out.println("I can speak");
    }

    public static void main(String[] args) {

        Parent p = new Child();
        p.canSpeak();

        // p.canRead()  // can not be accessed. because the refernece is parent.
        // if you want to access the canRead() method in child class, then you need to case the object.

        Child c = (Child)p;
        c.canRead();
    }
}

public class Child extends Parent {
    /**
     * This is the overridden method.
     */
    @Override
    public void canSpeak() {
        System.out.println("I can speak");
    }
    /**
     * Only child can read.
     */
    public void canRead() {
        System.out.println("I can read");
    }
}