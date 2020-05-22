static class B {
    private int f3;
    public B(int f) {
        f3 = f;
    }
}

public static void main(String[] args) {
    B b = new b(17);
    Field field = B.class.getDeclaredField("f3");
    field.setAccessible(true);
    System.out.println(field.get(b));
}