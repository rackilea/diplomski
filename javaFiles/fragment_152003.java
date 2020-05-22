public class AppManager
{
    private static AppManager   _instance;

    private AppManager()
    {

    }

    public synchronized static AppManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new AppManager();
        }
        return _instance;
    }
}