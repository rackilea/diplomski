class MyAsyncTask extends AsyncTask... {
    WeakReference<Activity> mActivity;

    public MyAsyncTask( Activity activity ) {
        super();
        mActivity = new WeakReference<Activity>( activity );
    }

    ...

    public void onPostExecute(...) {
        Activity act = mActivity.get();
        if( act != null ) {
            TextView tv = act.findViewById( ...id... );
            tv.setText( "Hello World" );
        } else {
            // the Activity was destroyed
        }
    }

}