boolean checkInput1( String input )
{
    return input.matches( "^[^bla]*$" );
}

boolean checkInput2( String input )
{
    if ( input.length() == 0 ) return true;
    return input.matches( "^[^@]+@.*$" );
}