interface A {
    int a(int g, int f, int h);
    int b(int x);
}

class B implements A {
    @Override
    public int a(int g, int f, int t) {
        System.out.println("called a in thread "+Thread.currentThread().getName());
        return 42;
    }
    @Override
    public int  b(int x) {
        System.out.println("called b in thread "+Thread.currentThread().getName());
        return 21;
    }
}