class Bill {

    private DoubleProperty amountDue = new SimpleDoubleProperty();

    // this will be picked up by Querydsl and treated as a property
    public double getAmountDue() { 
        return amountDue.get();
    }

    public void setAmountDue(double value) { 
        amountDue.set(value);
    }

    public DoubleProperty amountDueProperty() {
        return amountDue;
    }

}