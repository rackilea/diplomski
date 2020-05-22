public class MainActivity extends AppCompatActivity implements Interface.InterfaceCommon
    {
    public static Thread t1;
    FetchData fetchData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        t1 = new Thread();
        fetchData = new FetchData();
        }
    public void someMethod()
        {
        Runnable r = () ->
            {
            try
                {
                Thread.sleep(5000);
                }
            catch (InterruptedException e)
                {
                e.printStackTrace();
                }
            /// Some code
            };
        t1 = new Thread(r);
        try
            {
            FetchData.t2.join();
            t1.start();
            }
        catch (InterruptedException e)
            {
            e.printStackTrace();
            }
        }
    }

    public class FetchData extends AsyncTask<Void, Void, Void>
        {
        public static Thread t2;
        public FetchData()
            {
            t2 = new Thread();
            }
        protected final Void doInBackground(Void... params)
            {
            Runnable r = () ->
                {
                try
                    {
                    Thread.sleep(5000);
                    }
                catch (InterruptedException e)
                    {
                    e.printStackTrace();
                    }
                    /// Some code
                };
            t2 = new Thread(r);
            try
                {
                MainActivity.t1.join();
                t2.start();
                }
            catch (InterruptedException e)
                {
                e.printStackTrace();
                }
            }
        }
    }
}