int i = 0;
for( i = 0; i < wholeString.length(); i +=3 )
{
    splittedText.add( wholeString.substring( i, i + 2 ) );
}
if ( i < wholeString.length() )
{
    splittedText.add( wholeString.substring( i ) );
}