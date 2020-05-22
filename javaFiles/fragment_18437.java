/**
 *
 * @param <P> the type of the product.
 * @param <L> the linking interface.
 */
public class AbstractBuilder<P extends AbstractClass, L> implements ValueSetterOne<L>, ValueSetterTwo<L>{

    protected P toBeBuild;
    @Override
    public L setValueTwo(int value) {
        //set value
        return (L) this;
    }
    @Override
    public ValueSetterTwo<L> setValueOne(int value){
        //set value
        return this;
}