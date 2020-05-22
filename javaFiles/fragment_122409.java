String getMiddle(String a,String b,String c)
{
    String middle = "";
    if (a.compareTo(b)*a.compareTo(c) <= 0) middle = a;
    else if (b.compareTo(a)*b.compareTo(c) <= 0) middle = b;
    else if (c.compareTo(b)*c.compareTo(a) <= 0) middle = c;
    return middle;
}