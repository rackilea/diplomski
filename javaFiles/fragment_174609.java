protected void onRestoreInstanceState(Bundle savedInstanceState)
{
    // Call super first, to ensure that all the widget updates get in the queue first...
    super.onRestoreInstanceState(savedInstanceState);

    View view = getWindow().getDecorView().getRootView();

    view.post(new Runnable() 
    {
        public void run() 
        {
            myEditText.setError(...);
            .
            .
            .
        }
    });
}