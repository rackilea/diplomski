for(int i=0; i<len; i++)
{
    if(! (input.charAt(i) == '1' || input.charAt(i) == '0'))
    {
       return false;
    }
}
return true;