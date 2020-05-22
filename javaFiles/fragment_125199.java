class A {
    public void funct() {...}
}

class B extends A {
    @Override 
    public void funct() {
        super.funct();
    }
}