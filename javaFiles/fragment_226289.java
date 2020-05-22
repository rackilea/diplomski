public boolean passwordCheck(String password)
{
    if(password.length() < 8) return false;

    for(int i=0; i < password.length(); i++)
        if(!Character.isLetterOrDigit(password.charAt(i)))
            return false;

    return true;
}