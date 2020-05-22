public boolean isXRefStream()
{
    if (trailer != null)
    {
        return COSName.XREF.equals(trailer.getItem(COSName.TYPE));
    }
    return false;
}