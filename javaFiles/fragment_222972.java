public class TableData
{
    String beer;
    String brewery;
    String country;

    public TableData(String beer, String brewery, String country)
    {
        super();
        this.beer = beer;
        this.brewery = brewery;
        this.country = country;
    }

    public String getBeer()
    {
        return beer;
    }
    public String getBrewery()
    {
        return brewery;
    }
    public String getCountry()
    {
        return country;
    }

}