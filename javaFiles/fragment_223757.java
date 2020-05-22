public class ExampleClass
{
    private int number;

    public ExampleClass(int number)
    {
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public boolean equals(Object other)
    {
        boolean isEqual = false;

        if (other instanceof ExampleClass)
        {
            ExampleClass otherEC = (ExampleClass)other;

            isEqual = number == otherEC.number;
        }

        return isEqual;
    }

    @Override
    public int hashCode()
    {
        return number;
    }
}