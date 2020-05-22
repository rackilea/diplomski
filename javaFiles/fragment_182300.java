class SubA extends A {
    /** This is the one special aspect of SubA justifying a sub-class.
        Using double purely as an example. */
    private double specialProperty;

    public double getSpecialProperty() { return specialProperty; }
    public void setSpecialProperty(double newSP) { specialProperty = newSP; }

    public SubA() {
        super();
        // Important differences between SubAs and As go here....
        // If there aren't any others, you don't need this constructor.
    }

    // NOTE: you don't have to do anything else with the other methods of
    // A.  You just inherit those.
}

class SubB extends B {
    // Purely for the purposes of a slightly different factory method
    public A createA() {
        return new SubA();
    }

    // Or if you need a static method 
    // (this is usually instead of the first choice)
    public static A createA() {
        return new SubA();
    }
}