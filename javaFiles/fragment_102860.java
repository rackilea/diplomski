for (int i=0; i <= base.length()-remove.length(); i++)
{
    if (base.substring(i, i+remove.length()).equals(remove))
    {  
        base = base.substring(0, i) + base.substring(i + remove.length() , base.length());
        i--;
    }
}