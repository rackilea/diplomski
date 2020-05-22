public class MyPair
{
    private final Double key;
    private final Double value;

    public MyPair(Double aKey, Double aValue)
    {
        key   = aKey;
        value = aValue;
    }

    public Double key()   { return key; }
    public Double value() { return value; }
}