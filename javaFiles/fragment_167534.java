public enum e_Type
{
    e_Unknown,
    e_Categoric,
    e_Numeric;
    public static e_Type type(String token)
    {
        return e_Type.valueOf(token);
    }
    public static String token(e_Type t)
    {
        return t.name();
    }
}