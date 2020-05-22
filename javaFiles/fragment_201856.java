class A {
    B b;

    A() { 
        b = new B(getClass());
    }
}

class B {
    Class<?> parentClass;

    B(Class<?> parentClass) {
        this.parentClass = parentClass;
    }

    void createParent() throws Exception {
        Object o = parentClass.newInstance();
    }
}