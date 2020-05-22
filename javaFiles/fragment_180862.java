public final class ReturningValues 
{
    private final String value;
    private final int index;

    public ReturningValues( String value, int index ) 
    {
        this.value = value;
        this.index = index;
    }   

    public String getString()
    {
        return value;
    }

    public String getInteger()
    {
        return index;
    }
}