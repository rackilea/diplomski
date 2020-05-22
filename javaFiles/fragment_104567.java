public static String addZeichenkette(String out, int i) 
{
    if (i > 0)
    {
        out += "bla";
        i--;
        out = addZeichenkette(out, i); 

    }
    return out;
}