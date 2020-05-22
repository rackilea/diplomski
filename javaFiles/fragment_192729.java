String Password = "Abcd123$";
public static boolean UpperCasePresence(String Password)
{

    int UC = 0;
    for(int i=0;i<Password.length();i++)
    {
        if(Character.isUpperCase(Password.charAt(i)))
        {
            UC++;
        }
    }
    if(UC>=1)
    {
        System.out.println("Upper Case Count :" + UC );
        return true;
    }
    else
    {
        System.out.println("Upper Case Count is " + UC );
        return false;
    }
}


public static boolean LowerCasePresence(String Password)
{
    int LC = 0;
    for(int i=0;i<Password.length();i++)
    {
        if(Character.isLowerCase(Password.charAt(i)))
        {
            LC++;
        }
    }
    if(LC>=1)
    {
        System.out.println("Lower Case Count :" + LC );
        return true;
    }
    else
    {
        System.out.println("Lower Case Count is" + LC );
        return false;
    }
}

public static boolean SpecialCharPresence(String Password)
{

     Pattern p = Pattern.compile("[^A-Za-z0-9]");
     Matcher m = p.matcher(Password);
     boolean b = m.find();
     if (b == true)
     {
        System.out.println("Special character are there in Password");
        return true;
     }
     else
     {
         System.out.println("There is no special char in Password");
         return false;
     }


}


public static boolean NumberPresence(String Password)
{

     Pattern p = Pattern.compile("([0-9])");
     Matcher m = p.matcher(Password);
     boolean b = m.find();
     if (b == true)
     {
        System.out.println("Numbers are there in Password ");
        return true;
     }
     else
     {
         System.out.println("There is no Numbers in Password");
         return false;
     }


}