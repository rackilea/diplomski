void SimpleNode production():
{}
{
    (
        <PROD_NAME>
        ( LOOKAHEAD({getToken(1).kind == PROD_NAME && getToken(1).image.equals("state")})
         <PROD_NAME>
         ...
        |
         { int[][] expTokSeqs = new int[][] { new int[] {STATE } } ;
           throw new ParseException(token, expTokSeqs, tokenImage) ; }
        )
    )
    {return jjtThis;}
}