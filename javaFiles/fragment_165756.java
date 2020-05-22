public static boolean validate(String ccnum)
{
   // ... -snip-
        if(sum%10==0)
            return true;
        else
            return false;
    }else
        return false;
}