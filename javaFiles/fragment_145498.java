public abstract class parent {
    private int field = 0;

    public parent(int f) {
         field = f;
    }


    public void m1() { /* m1's implementation */ }
    public void m2() { /* m2's common implementation */ }
}

public class child1 {
    public child1() {
        super(1);
    }

    @Override
    public void m2() { super.m2() /* m2's child1 implementation */ }
}

public class child2 {
    public child2() {
        super(2);
    }

    @Override
    public void m2() { super.m2() /* m2's child2 implementation */ }
}