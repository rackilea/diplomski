class SomeClass {

    public SomeClass() {

        doSomething();//Warning - Overridable method call in constructor
        SomeClass.this.doSomething();//Seems OK
    }

    public final void doSomething() {
        System.out.println("parent");
    }
}