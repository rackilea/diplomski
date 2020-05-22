static class Task extends AsyncTask<Void, Void, Void> {

    adapter mAdapter; 

    Task(adapter adapter)  {
       mAdapter = adapter;
    }

    @Override
    protected Void doInBackground(Void... params) {
      // the code from the Runnable using the mAdapter instead of info.
    return null;
}