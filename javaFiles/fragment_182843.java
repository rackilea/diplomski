public void helloWorld(String str)
{
     str = "something"; // OK
}


public void helloWorld(final String str)
{
    str = "something"; // ERROR
}