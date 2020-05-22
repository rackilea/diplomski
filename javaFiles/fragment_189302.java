class FooValidatingDecorator extends ValidatingListDecorator {

    public FooValidatingDecorator(List<MyBusinessObject> target)
    {
        super(target);
    }

    @Override
    protected void validate(MyBusinessObject element)
    {
        //throw if "foo" not met
    }
}

class BarValidatingDecorator extends ValidatingListDecorator {

    public BarValidatingDecorator(List<MyBusinessObject> target)
    {
        super(target);
    }

    @Override
    protected void validate(MyBusinessObject element)
    {
        //throw if "bar" not met
    }
}