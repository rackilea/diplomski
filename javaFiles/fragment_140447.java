public class Superclass {
    private Object foo;

    public Superclass() {
        HugeObject huge = getHugeObject();
        gotHugeObject(huge);
    }

    /*
     * NB: Called during construction! Beware of leaking `this` etc.!!!
     */
    protected void gotHugeObject(HugeObject huge) {
        this.foo = huge.getFoo();
    }
}

public class Subclass extends Superclass {
    private Object bar;

    /*
     * NB: Called during construction! Beware of leaking `this` etc.!!!
     */
    @Override
    protected void gotHugeObject(HugeObject huge) {
        super.gotHugeObject(huge);
        this.bar = huge.getBar(); // “huge” gets garbage collected, too

    }
}