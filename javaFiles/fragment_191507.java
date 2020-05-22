public static void main(String[] args) {
    B<Integer, String> b = new B<Integer, String>();
    b.a = 1;
    b.b = "one";

    b.add(1);
    b.add(2);
}

public static class A<T> extends ArrayList<T> {
    public T a;
}

public static class B<U, T> extends A<U> {
    public T b;
}