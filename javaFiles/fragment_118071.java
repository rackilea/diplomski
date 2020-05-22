class Test
{
    static void Main()
    {
        DateTimeOffset epoch = new DateTimeOffset(1970, 1, 1, 0, 0, 0,
                                                  TimeSpan.Zero);
        TimeSpan millis = TimeSpan.FromMilliseconds(1111111111);
        // Prints 1970-01-13 20:38:31Z
        Console.WriteLine((epoch + millis).ToString("u"));
    }
}