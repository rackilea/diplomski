if (inputHelp.length() <= 1)
{
    det = true;
}
else if (inputHelp.substring(0, 1)
             .equals(inputHelp.substring(inputHelp.length() - 1)))
{
    inputHelp = inputHelp.substring( 1, inputHelp.length() - 1);
    det = palindrome(inputHelp);
}
else 
{
    det = false;
}