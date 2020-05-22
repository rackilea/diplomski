public class X {

}

public class Y {

    public Y(String s, X x) {

    }
}

public class Main {

    public static X x = new X();
}

public class SomeSingletonClass {

    private Queue<Y> someQueue = new LinkedList<>();;

    private SomeSingletonClass() {
        someQueue.add(new Y("Hello", Main.x));
    }

}