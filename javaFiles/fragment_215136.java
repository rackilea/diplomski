interface A {
    public A another();
}

interface B {
    public B another();
}

interface AB extends A,B {
    public AB another();
}