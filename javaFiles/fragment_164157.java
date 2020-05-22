int ResolveTransparentStatusBarFlag()
{
    String[] libs = getPackageManager().getSystemSharedLibraryNames();
    String reflect = null;

    if (libs == null)
        return 0;

    for (String lib : libs)
    {
        if (lib.equals("touchwiz"))
            reflect = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
        else if (lib.startsWith("com.sonyericsson.navigationbar"))
            reflect = "SYSTEM_UI_FLAG_TRANSPARENT";
    }

    if (reflect == null)
        return 0;

    try
    {
        Field field = View.class.getField(reflect);
        if (field.getType() == Integer.TYPE)
            return field.getInt(null);
    }
    catch (Exception e)
    {
    }

    return 0;
}