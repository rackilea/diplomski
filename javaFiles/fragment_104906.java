public String reverse(String string)
{
    String areverse = "";
    for (int x = string.length(); x>0; x--)
    {   
        areverse += string.charAt(x - 1);
    }
    return areverse;
}