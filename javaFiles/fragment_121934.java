class A {
    protected String str = "A";
    public static int i = 1;
    public A() {
        foo();
    }
    public void foo() {
        // TODO Auto-generated method stub
        System.out.println(str + " " + i);
    }
}
 class B extends A {
    public static int i = 2;
    public B() {
        foo();
    }
    public void foo() {
        // TODO Auto-generated method stub
        System.out.println(str + " " + i);

    }
}