public static void main( String[] args ) {

        String myString = "Your test string here...";

        List< Character > alreadyDone = new ArrayList< Character >( );

        for ( Character myChar: myString.toCharArray( ) ) {

            if ( alreadyDone.contains( myChar ) ) {
                continue;
            }

            System.out.println( myChar + ": " + getCount( myString, myChar ) );
            alreadyDone.add( myChar );
        }

    }

    // recursive method to calculate the occurrence of a character in a string

    private static int getCount( String string, char myChar ) {

        if ( string.length( ) == 0 ) {
            return 0;
        }

        if ( string.charAt( 0 ) == myChar ) {
            return 1 + getCount( string.substring( 1 ), myChar );
        }

        return getCount( string.substring( 1 ), myChar );
    }