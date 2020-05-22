public static String GetObjectAsStringWithFilter(FilterProvider filters, Object jsonObject)
{
    if (jsonObject == null)
    {
        return null;
    }
    String objectAsString = null;
    try
    {
        objectAsString = objectMapper.writer(filters).writeValueAsString(jsonObject);
    }
    catch (Exception e)
    {
        ...
    }

    return objectAsString;
}