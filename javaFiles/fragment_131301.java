class SomeOtherClass
{
    void DoSomething(Func<int, string> bar);
}

new SomeOtherClass().DoSomething(delegate(int i) { return i.ToString(); });