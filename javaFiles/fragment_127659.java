public boolean hasAllDigitsSame (int i)
{
    int a = i ;
    int m = a % 10 ;
    int mm = m ;
    while(a > 0)
    {
        m = a % 10;
        if (m != mm)
          return False ;
        a /= 10 ;
    }
    return True ;
 }