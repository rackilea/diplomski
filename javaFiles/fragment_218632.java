Foo original = new Foo(3, "bar") {
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }
};
Foo copy = original.clone();
System.out.println(copy.getA());
System.out.println(copy.getB());
copy.run();
System.out.println(copy == original);