public static class MyBean {

    private IntegerProperty valA; 
    private IntegerProperty valB;

    public MyBean(int valA) {
        this.valA = new SimpleIntegerProperty(this, "valA", valA);
        this.valB = new SimpleIntegerProperty(this, "valB", 0);
        updateB(this.valA, null, this.valA.get());
        BidirectionalBinding.<Number, Number>bindBidirectional(
                this.valA, this.valB, this::updateB, this::updateA);
    }

    protected void updateB(ObservableValue<? extends Number> source,  Number old, Number value) {
        setValB(value.intValue() * 2);
    }

    protected void updateA(ObservableValue<? extends Number> source, Number old, Number value) {
        setValA(value.intValue() / 2);
    }

    ... // same as in OP's code
}