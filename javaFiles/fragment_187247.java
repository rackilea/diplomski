public class Application
{
    private Application() { } // make your constructor private, so the only war
                              // to access "application" is through singleton pattern

    private static Application _app;

    public static Application getSharedApplication() 
    {
        if (_app == null)
            _app = new Application();
        return _app;
    }
}