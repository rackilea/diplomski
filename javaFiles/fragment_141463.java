Class1
{
    public Class1()
    {
        Class2 object = new Class2(this);
    }

   public SomeMethod(String anyString)
   {...}
}

Class2
{
    public Class2(Class1 parent)
    {
         parent.SomeMethod("A String value");
    }
}