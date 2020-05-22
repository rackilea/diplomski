public int OneChar ( String c )   
    {

        if ( c.equals ( "" ) )
            return 1;
        else   
        {
            char first = c.charAt ( 0 );
            System.out.println ( first );
            if(c.length() > 2) {
                c = c.substring ( 2 );
                return OneChar ( c );
            }
            return 1;
        }
    }