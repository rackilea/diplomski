public class Num {
    protected int a;

    public Num() { a = 1; }

    public int calc() {
        int c = a + 4;
        return c;
    }
}

public class Two extends Num {
    public Two() { a = 2; }
}