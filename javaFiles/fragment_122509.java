public class MyAsyncTask extends AsyncTask<String, Void, String>
{
    private MainActivity mainActivity;

    public MyAsyncTask(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }
}