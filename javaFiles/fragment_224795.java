public class AdjFactor 
{
    // ....
    @Override
    public int hashCode()
    {
        return demo ^ month ^ year ^ site;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final AdjFactor other = (AdjFactor) obj;
        return demo == other.demo
            && month == other.month
            && year == other.year
            && site == other.site;
    }
}