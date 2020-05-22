class ExampleTask<T,S,U> extends AsyncTask<T,S,U>
{
    public interface ExampleListener
    {
        public void onTaskCompleted(boolean success);
    }

    private ExampleListener mListener;

    public ExampleTask(ExampleListener listener)
    {
        mListener = listener;
    }

    ...
    @Override
    protected void onPostExecute(U result)
    {
        ...
        if (mListener != null)
        {
            mListener.onTaskCompleted(yourBooleanResult);
        }
    }
}