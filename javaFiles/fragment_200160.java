void SimpleNode production():
{}
{
    (
        <PROD_NAME>
        ( LOOKAHEAD({getToken(1).kind == PROD_NAME && getToken(1).image.equals("state")})
         <PROD_NAME>
         ...
        |
         ...other choices...
        )
    )
    {return jjtThis;}
}