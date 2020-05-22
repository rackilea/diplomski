public static String check(String str)
{


    // Strips the string down to only letters a-z and numbers 0-9, and makes it lowercase
    str = str.replaceAll("[^A-Za-z0-9]", "");
    str = str.replaceAll("\\s+","");
    str = str.toLowerCase();

    if (str.length() <= 1)
    {
        return ("The string is a palindrome" );


    }
    else if ((str.charAt(str.length() - 1)) == (str.charAt(0)))
    {
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return check(sb.toString());
    }
    else
    {
        return "The string is not a palindrome";

    }
}