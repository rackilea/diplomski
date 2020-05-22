interface Interface {
    void visit(OtherClass methodHolder);
}

class A implements Interface {
    public void visit(OtherClass methodHolder) {
        methodHolder.doSomething(this);
    }
}

class B implements Interface {
    public void visit(OtherClass methodHolder) {
        methodHolder.doSomething(this);
    }
}