public enum TradingSector
{
    EMPLOYEE( "M" ),
    CUSTOMER( "C" ),
    NOSTRO( "N" ),
    FUND( "F" );

    private final String ch;

    private TradingSector( String ch )
    {
        this.ch = ch;
    }

    public String getCharacter()
    {
        return this.ch;
    }

    public static TradingSector translate( String ch )
    {
        for ( TradingSector ts : TradingSector.values() )
        {
            if ( ch.equals( ts.getCharacter() ) )
            {
                return ts;
            }
        }

        return null;
    }
}