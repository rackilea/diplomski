enum Temperature
{
    HOT      (0),
    COLD     (250),
    MODERATE (500);

    private final int cal;

    Temperature(final int cal)
    {
        this.cal = cal;
    }

    public int getCal()
    {
        return cal;
    }
}