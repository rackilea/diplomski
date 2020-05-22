static void degitir(String s)
{
    try
    {
        final char [] newValue = "Hello world".toCharArray();

        Field f = String.class.getDeclaredField("count");
        f.setAccessible(true);
        f.set(s, newValue.length);

        f = String.class.getDeclaredField("value");
        f.setAccessible(true);
        f.set(s, newValue);

    }
    catch (Exception e)
    {
         e.printStackTrace();
    }
}