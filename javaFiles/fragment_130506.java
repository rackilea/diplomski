public class Positive {
public static void main(String[] args) {
    Positive p = new Positive(5);
    Positive v = new Positive(17);
    int result = add(p,v);
    System.out.println(result);
}
private int n;

public Positive(int n) {
    this.n = n;
}

public static int add(Positive p, Positive v)
{
    return p.get() + v.get();
}

public int get() {
    return n;
}
}