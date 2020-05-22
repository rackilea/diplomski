class Second {
    int c, d;
    public int getC() { return c; }
    public int getD() { return d; }
}

class First extends Second {
    int a, b;

    public int getA() { return a; }
    public int getB() { return b; } 
}

public static void main(String[] args) {
    List<First> firstList = new ArrayList<>();
    List<? extends Second> secondList = firstList;
}