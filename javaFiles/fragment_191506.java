public static void main(String[] args) {
    B<Integer> b = new B<Integer>();
    b.a = 1;
    b.b = "one";

    b.add(1);
    b.add(2);
}

public static class A<T> extends ArrayList<T> {
    public T a;
}

public static class B<T> extends A<T> {
    public T b;
}