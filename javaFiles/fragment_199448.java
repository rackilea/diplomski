public class IntWrapper
{
    int value;
}
...

public static boolean myParseInt(String s, IntWrapper outValue)
{
    try
    {
        outValue.value = Integer.parseInt(s);
        return true;
    }
    catch(NumberFormatException e)
    {
        return false;
    }
}
...

IntWrapper value = new IntWrapper();
if (myParseInt(value))
{
    // Use value.value
}
else
{
    // Parsing failed
}