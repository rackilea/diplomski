public static void main (String[] args) throws java.lang.Exception
{
        String S = "5,a\n" +
           "6,b\n" +
           "9,a";

        String[] lines = S.split("\\n");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for( String t : lines )
        {
            String[] e = t.split(",");
            Integer digit = Integer.parseInt(e[0]);
            String c = e[1];
            if ( map.get(c) != null )
            {
                Integer val = map.get(c);
                val += digit;
                map.put( c, val );
            }
            else
            {
                map.put( c, digit );
            }

        }

        int max = 0;
        String maxKey = null;
        for ( String k : map.keySet() )
        {
            if ( map.get(k) > max )
            {

                max = map.get(k);
                maxKey = k;
            }
        }

        System.out.println("The maximum key is : " + maxKey );
        System.out.println("The maximum value is : " + max );
    }