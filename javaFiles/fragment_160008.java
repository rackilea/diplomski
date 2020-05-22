private static MainActivity activity;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    activity = this;

}

public static void finishThis()
{
    try
    {
        if (activity != null)
        {
            activity.finish();
        }
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}