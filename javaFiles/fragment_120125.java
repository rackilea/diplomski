public class MyBean extends EventBean {

    private boolean typedA;

    public void setTypedA(final boolean newValue) {
        // you can do validation on the newValue here
        final boolean oldValue = typedA;
        super.firePropertyChanged("typedA", oldValue, newValue);
        this.typedA = newValue;
    }
    public boolean getTypedA() { return this.typedA; }

}