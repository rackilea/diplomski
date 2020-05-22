public class ConcreteClass extends AbstractClass<ConcreteProp> {

    @Override
    public void setProperty(final ConcreteProp someProperty) {
        this.someProperty = someProperty;
    }
}