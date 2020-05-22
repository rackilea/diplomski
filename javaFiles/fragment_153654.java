protected final static int getResourceID
(final String resName, final String resType, final Context ctx)
{
    final int ResourceID =
        ctx.getResources().getIdentifier(resName, resType,
            ctx.getApplicationInfo().packageName);
    if (ResourceID == 0)
    {
        throw new IllegalArgumentException
        (
            "No resource string found with name " + resName
        );
    }
    else
    {
        return ResourceID;
    }
}