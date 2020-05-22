class AccessibleA extends A {
    private Consumer<Integer> setter;
    ...
    AccessibleA() {
        EvilVisitor e = new EvilVisitor();
        e.accept(this);
    } 
    void setSetter(Consumer<Integer> setter) { this.setter = setter; }
    ...
    // Here's our public setter now:
    void setValue(int i) { setter.accept(i); }
}

class EvilVisitor {
    private AccessibleA accessibleA;
    ...
    public void setSetter(Consumer<Integer> setter) {
        accessibleA.setSetter(setter);
    }
    ...
}