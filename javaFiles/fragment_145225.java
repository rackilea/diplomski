interface MyInterface{
    void someMethod();
}

class A implements MyInterface{
    B bInst;
    public void someMethod(){
    }

    public void bar() {
        bInst = new B(this);
    }
}

class B {
    private MyInterface x;

    B(MyInterface y) {
        this.x=y;
    }

    private void foo(){
        x.someMethod();
    }    
}