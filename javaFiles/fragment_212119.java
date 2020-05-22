Map<String, String> params = new HashMap<String, String>();
String[] paramSplits = buffer.toString().split("&");
String[] valueSplits;

if (paramSplits.length > 1)
{
    for (String param : paramSplits)
    {
        valueSplits = param.split("=");
        if (valueSplits.length > 1)
        {
            // add this check to handle empty phone number fields
            params.put(decode(valueSplits[0]), decode(valueSplits[1]));
        }
    }
}