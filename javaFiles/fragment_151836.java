public static boolean copies(String whole, String part, int check)
{

    //check if current string length is valid
    if(whole.length() < part.length())
    {
        //check if check parameter equals part instances
        if(check == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //check if current string value is an instance of part 
    if(whole.substring(0, 3).equals(part))
    {
        check--;
    }
    return return copies(whole.substring(1), part, check);
}