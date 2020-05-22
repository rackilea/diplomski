public String getString(String stringname)
{
    try
    {
        byte ptext[] = this.xml.get(stringname).getBytes("ISO-8859-1");
        String value = new String(ptext, "UTF-8");
        return value;
        // catch if not found
    }
    catch (com.badlogic.gdx.utils.GdxRuntimeException e)
    {
        Logger.error("String not found: " + stringname + " "
                + e.getMessage());
        return "";
    }
    catch (UnsupportedEncodingException e)
    {
        Logger.error("encoding failed " + stringname + " "
                + e.getMessage());
        return "";
    }
}