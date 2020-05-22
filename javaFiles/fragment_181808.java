public abstract class BaseTemplate {
    public String doSomething()
    {
        // whatever
        return "Hello";
    }

    public int anotherRealMethod(String data)
    {
        //also whatever
        return 0;
    }

    public abstract String templateMethod(String data);
}