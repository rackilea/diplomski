public class MyPojo
{
    private String date;

    private Rates rates;

    private String base;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public Rates getRates ()
    {
        return rates;
    }

    public void setRates (Rates rates)
    {
        this.rates = rates;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [date = "+date+", rates = "+rates+", base = "+base+"]";
    }

public class Rates
{
    private String CHF;

    private String EUR;

    private String GBP;

    private String CAD;

    private String USD;

    private String SEK;

    public String getCHF ()
    {
        return CHF;
    }

    public void setCHF (String CHF)
    {
        this.CHF = CHF;
    }

    public String getEUR ()
    {
        return EUR;
    }

    public void setEUR (String EUR)
    {
        this.EUR = EUR;
    }

    public String getGBP ()
    {
        return GBP;
    }

    public void setGBP (String GBP)
    {
        this.GBP = GBP;
    }

    public String getCAD ()
    {
        return CAD;
    }

    public void setCAD (String CAD)
    {
        this.CAD = CAD;
    }

    public String getUSD ()
    {
        return USD;
    }

    public void setUSD (String USD)
    {
        this.USD = USD;
    }

    public String getSEK ()
    {
        return SEK;
    }

    public void setSEK (String SEK)
    {
        this.SEK = SEK;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CHF = "+CHF+", EUR = "+EUR+", GBP = "+GBP+", CAD = "+CAD+", USD = "+USD+", SEK = "+SEK+"]";
    }
}
}