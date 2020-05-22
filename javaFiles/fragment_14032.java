public class TestSuper {
    int a = 0;
    public int getA() { return a; }
}

public class TestSub extends TestSuper {
    int a = 1;
    public int getA() { return a; }
}

public class TestSub2 extends TestSuper {
    int a = 2;
    public int getA() { return a; }
}

public static int test(TestSuper b) {
    return b.getA();
}