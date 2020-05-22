// wrap 3rd party code, expose it as some java.*.* interface
public class MyWrapper implements Callable<String>
{
    @Override 
    public String call()
    {
        return ThirdParty.query(..);
    }
}



HotReloader hot = new HotReloader();
Callable<String> func = (Callable<String>)hot.getAppInstance("pkg.MyWrapper");
String result = func.call();
// then dereference `hot` and `func`