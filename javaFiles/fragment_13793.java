abstract class Parent {
    private int ID;

    Parent() {
         ID = nextId();
    }

    abstract protected int nextId();
}

class Sub1 extends Parent {
    private static int curID = 0;

    protected int nextId() {
       return curID++;
    }

    //...
}

class Sub2 extends Parent {
    private static int curID = 0;

    protected int nextId() {
       return curID++;
    }

    //...
}