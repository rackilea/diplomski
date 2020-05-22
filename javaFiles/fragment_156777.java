static
{
    try
    {
        int i = 10 / 0;
    }
    catch (ExceptionInInitializerError | ArithmeticException e)
    {
        e.printStackTrace();
    }
}