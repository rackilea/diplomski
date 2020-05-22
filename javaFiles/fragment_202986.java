@Override
public boolean equals(Object obj)
{
    if(!(obj instanceof Fraction))
    {
        return false;
    }
    else
    {
        Fraction f = (Fraction)obj;
        return top*f.bottom == bottom*f.top;
    }
}