public static void main(String[] args) throws Exception {
    C c = new C();
    System.out.println("c:" + c.x);
    System.out.println("a:" + ((A)c).x);
    c.changeAX();
    System.out.println("c:" + c.x);
    System.out.println("a:" + ((A)c).x);
}

static class A {
    int x;
}

static class B extends A {
    int x;
}

static class C extends B {
    int x;

    public void changeAX() {
        ((A)this).x = 4;
    }
}