private boolean ruleTwo (String s1, String s2)
{
    if (s1.length() != s2.length())
        return false;


    int different = 0;
    for (int i=0; i<s1.length() && different <= 1; i++)
    {
        if (s1.charAt(i) != s2.charAt(i))
            different ++;
    }

    return different == 1;
}