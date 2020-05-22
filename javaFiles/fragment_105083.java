private class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    boolean cancelled = false;
    public void cancel() {
        cancelled = true;
    }

    public void doInBackground() {
        while(!cancelled) {
            ...
    }
    ...
}

...

MyAsyncTask task1 = new MyAsyncTask().execute();
MyAsyncTask task2 = new MyAsyncTask().execute();
MyAsyncTask task3 = new MyAsyncTask().execute();

...

if(needToCancelTask2) {
    task2.cancel();
}