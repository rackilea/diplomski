public static String findPassword(Password p,int length)
  {
      // string and char to be input into the overloading method
      String pswd= "";
      char char2Check = 'a';

      // Checking if the length of the password is 0 so its null
      if (length == 0)
      {
          return "";
      }
      else{
          // going to the overloading method to find the password
          return findPassword(p,length, pswd, char2Check);
      }
  }

  public static String findPassword(Password p,int length, String pswd, char      char2Check)
  {

    // Checking if the length of the password finder is less then the length of the 
    // password we add more chars until they are the same length to check if they're equal
    if (pswd.length() < length)
    {
        pswd+= char2Check;
        pswd = findPassword(p,length,pswd,char2Check);
        char2Check = pswd.charAt(pswd.length() - 1);
        if (pswd.length() < length)
        {
            if (pswd.length() == 0)
            {
                if (char2Check == 'z')
                {
                    return pswd;
                }
                if (char2Check < 'z')
                {
                    char2Check++;
                    pswd += char2Check;
                    return findPassword(p, length, pswd, char2Check);
                }
            }else{
                if (char2Check == 'z')
                {
                    return pswd.substring(0, pswd.length() - 1);
                }
                if (char2Check < 'z')
                {
                    char2Check = pswd.charAt(pswd.length() - 1);
                    pswd = pswd.substring(0, pswd.length() - 1);
                    char2Check++;
                    pswd += char2Check;
                    return findPassword(p, length, pswd, 'a');
                }
            }
        }
    }
    // Checking if the password finder length is the same as the original password
    if (pswd.length() == length)
    {
        System.out.println(pswd);
        // Checking if the two password match, if so we return the password finder.
        if (p.isPassword(pswd))
        {
            return pswd;
        }
        // Checking if the char is not the last char -> z
        if (char2Check < 'z')
        {
            pswd = pswd.substring(0, pswd.length() - 1);
            char2Check++;
            pswd+= char2Check;
            return findPassword(p,length,pswd,char2Check);
        }
        if (char2Check == 'z')
        {
            return pswd.substring(0, pswd.length() - 1);
        }
    }
    return pswd;
}