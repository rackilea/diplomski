public static class MyContainer
{
    private static int _myStatic;

    public static void PrintMe(string someString)
    {
        Console.Out.WriteLine(someString);
        _myStatic++;
    }

    public static int PrintedInstances()
    {
        return _myStatic;
    }
}