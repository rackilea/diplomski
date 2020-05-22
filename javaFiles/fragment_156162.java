public static void main(String[] args) {
    removeDuplicates(new char[]{'a','a','b','b','c','d','c'});
}

public static final void removeDuplicates(char[] str)
{
    /*
     * If the str is not instantiated, or there is maximum 1 char there is no need to remove duplicates as 
     * it is just impossible to have duplicate with 1 char.
    */
    if (str == null || str.length < 2)
        return;

    //loop over each char
    for(int i = 0; i < str.length; i++)
    {
        //no need to check with earlier character as they were already checked, so we start at i + 1
        for(int j = i + 1; j < str.length; j++)
        {
            //if they match we clear
             if(str[j] == str[i])
                str[j] = ' ';
        }
    }

    System.out.println(str);
}