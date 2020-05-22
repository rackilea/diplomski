public <T extends Resource> T getAsset(int resourceId)
{
    try
    {
        T ReturnAsset = (T)resources.get(resourceId);
        return ReturnAsset;
    }
    catch(ClassCastException cce)
    {
        Log.w("Resource", "Invalid cast of asset "+cce.toString());
        return null;
    }
}