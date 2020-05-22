public Object getVal(Object aKey, Object aDefaultValue)
{
    Element element = null;

    if (Util.isAlive())
    {
        try
        {
            element = cache.get(aKey);
        }
        catch (IllegalStateException e)
        {
            //Log it
        }
        catch (RuntimeException r)
        {
            //Log it
        }
    }

    return ((element == null) ? aDefaultValue : element.getObjectValue());
}