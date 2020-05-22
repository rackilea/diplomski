public static boolean match(String x, String y) {

    //if both are empty
    if(x.length()==0 && y.length()==0) return true;

    //if one is empty
    if(x.length()==0 )
    {
        if(y.charAt(0)!='*')
            return false;
        if(y.length()!=1)
            //border line case
            return match(x,y.substring(1));
        else 
            return true;
    }
    if(y.length()==0 )
    {
        if(x.charAt(0)!='*')
            return false;
        if(x.length()!=1)
            //border line case
            return match(y,x.substring(1));
        else 
            return true;
    }   

    //Base case 
    if(x.equals(y) || x.equals("*") || y.equals("*"))
    {

        return true;//we are done as strings are equal
    }


    //we are here that means strings are not equal yet 
    if(x.charAt(0)=='@' || y.charAt(0)=='@' ||x.charAt(0)==y.charAt(0))
    {
        if(x.length()==1 && y.length()==1) return true;//this was the last character
        if(x.length()>1 && y.length()>1)
        {

            //we have single char wild card or char 0 equal,  lets remove the char at 0th location and check again 
            return (match(x.substring(1),y.substring(1)));
        }
    }

    if(x.charAt(0)=='*')
    {
        //this is interesting now, we will need to skip 0..n number of characters till we find matching pattern
        //case 0 chars: he*llo and hello
        if(match(x.substring(1),y)==true)
            {
                return true;
            }
        else if (match(x.substring(1),y.substring(1))==true)
        {
            //case 1: he*lo and hello
            return true;
        }           
        else
        {
            //case n chars: h*o and hello
            return (match(x, y.substring(1)));
        }

    }

    if(y.charAt(0)=='*')
    {
        //this is interesting now, we will need to skip 0..n number of characters till we find matching pattern
        //case 0 chars: he*llo and hello
        if(match(y.substring(1),x)==true)
            {
                return true;
            }
        else if (match(x.substring(1),y.substring(1))==true)
        {
            //case 1: he*lo and hello
            return true;
        }           
        else
        {
            //case n chars: h*o and hello
            return (match(y, x.substring(1)));
        }

    }
    //nothing worked out
    return false;
}