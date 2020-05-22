public enum TierEnum
{
    Express( "Exp"),
    Standard( "Std");

    private String abbr;

    private TierEnum( String aAbbr )
    {
        abbr = aAbbr;
    }


    public String getAbbr()
    {
        return abbr;
    }
}