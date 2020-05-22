private void doubleArray( )
{
        String [ ] newArray;

        newArray = new String[ theArray.length * 2 ];
        for( int i = 0; i < theArray.length; i++ )
            newArray[ i ] = theArray[ i ];
        theArray = newArray;