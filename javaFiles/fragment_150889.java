class OnlyOddInputsSquarer extends Squarer
{
    @Override
    public void setValue(int v)
    {
        if (v % 2 == 0)
        {
            print("Sorry, this class only lets you square odd numbers!")
            return;
        }
        super.setValue(v);
    }
    @Override
    public void square()
    {
        super.setValue(getValue() * getValue());
    }
}