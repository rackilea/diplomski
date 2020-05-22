public abstract class ValidatingListDecorator extends AbstractList<MyBusinessObject>
{

    private final List<MyBusinessObject> target;

    public ValidatingListDecorator(List<MyBusinessObject> target) {
        this.target = target;
    }

    @Override
    public MyBusinessObject set(int index, MyBusinessObject element)
    {
        validate(element);
        return target.set(index, element);
    }

    protected abstract void validate(MyBusinessObject element);

}