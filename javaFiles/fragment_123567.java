public class MethodLab
{
    private static MethodProvider provider = null;
    public static MethodProvider get()
    {
        //Not thread safe...
        if(provider == null)
        {
             provider = new MethodProvider();
             provider.getMethod().setName("Abby");
        }
        return provider.clone();
    } 

    public static set(MethodProvider newProvider)
    {
        provider = newProvider;
    }
}