for(int i = 0; i < or.length; i++)
{
    try
    {
        returned = Integer.parseInt(Character.toString(or[i]));
    }

    catch (Exception e)
    {
        continue;
    }

    if(returned != 0)
    {
        or[i] = (char) (returned + 2080);
    }
}