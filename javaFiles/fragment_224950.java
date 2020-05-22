public void Main(string[] args)
{
    Func<int> returns42 = () => 42;
    Func<string,bool> amIPretty = name => name == "jerkimball";
    Action<int> foo = x => {};
}