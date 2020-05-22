public enum Status 
{
    OPERATOR_CREATED("Operator created"),
    ACTIVE("Active"),
    END_DATED("End dated");

    private String name;

    Status(String status) 
    {
       name = status;
    }

    public String toString()
    {
       return name;
    }

    public Status fromString( String value )
    {
        if ( "Operator created".equals( value ) 
        {
            return OPERATOR_CREATED;
        }
        //etc
    }
}