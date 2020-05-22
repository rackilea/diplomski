public boolean palindrome(String b)
{
    if (b.length() <= 1)
    {
        return true;
    }

    if (b.substring(0, 1)
           .equals(b.substring(b.length() - 1)))
    {
        return palindrome(b.substring(1, b.length() - 1));
    }

    return false;
}