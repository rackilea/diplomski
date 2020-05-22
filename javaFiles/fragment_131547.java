abstract class Parent {
    Parent() {
        /*some code*/
        childInit();
        finalSetup();
    }
    void finalSetup() {/*code that dependent on the fact that the child constructor has run*/}
    abstract void childInit();
}

class Child extends Parent {
    @Override
    void childInit() {
        /* the code you would put in child's constructor */
    }
}