class Range<T extends AsStringable>
{
    private T min;
    private T max;

    Range(T min, T max)
    {
        this.min = min;
        this.max = max;
    }  

    String makeString()
    {
        return "The range is from " + min.asString() + " to " + max.asString();
    }
}