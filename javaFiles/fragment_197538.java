if ( matcher.matches ( ) )
        {
            if( rangeInclusive ( Integer.parseInt ( matcher.group(1) ) , Integer.parseInt ( matcher.group(2) ), -50 , 50 ) &&
                    rangeInclusive ( Integer.parseInt ( matcher.group(3) ) , Integer.parseInt ( matcher.group(4) ), -50 , 50 ))
            {
                double dist = Math.sqrt( Math.pow ( Long.parseLong ( matcher.group(3) ) - Long.parseLong ( matcher.group(1) ) , 2 ) + 
                        Math.pow ( Long.parseLong ( matcher.group(4) ) - Long.parseLong ( matcher.group(2) ) , 2 ) );
                System.out.println ( "Distance: " + dist );
            }
            else
            {
                System.out.println ( "Wrong range" );
            }

        }