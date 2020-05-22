public static enum InstrumentType {

    SPOT("MKP"),
    VOLATILITY("VOL");

    private final String name;

    InstrumentType(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }

    public static InstrumentType getValue(String s)
    {
        for (InstrumentType t : InstrumentType.values())
        {
            if (t.toString().equals(s))
                return t;
        }
        return SOME_DEFAULT_VALUE;
    }
}