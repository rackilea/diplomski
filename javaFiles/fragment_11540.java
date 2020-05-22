try
{
    throw new ArgumentException("some operation that throws an exception");
    string s = "blah";
}
catch (e as ArgumentException)
{  
    Console.Out.WriteLine(s);
}