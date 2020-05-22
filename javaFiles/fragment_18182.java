public abstract class AbstractClass<T extends AbstractProp> {
    protected T someProperty;

    public void setProperty(T someProperty) {
        this.someProperty = someProperty;
    }
}