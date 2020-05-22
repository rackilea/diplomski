public interface MyInterface {
    public void myMethod(boolean result);
}

public class AsyncConnectTask extends AsyncTask<Void, Void, Boolean> {

    private MyInterface mListener;


    public AsyncConnectTask(Context context, String address, String user,
        String pass, int port, MyInterface mListener) {
        mContext = context;
        _address = address;
        _user = user;
        _pass = pass;
        _port = port;
        this.mListener  = mListener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        ....
        return result;
   }


    @Override
    protected void onPostExecute(Boolean result) {
        if (mListener != null) 
            mListener.myMethod(result);
    }
}

AsyncConnectTask task = new AsyncConnectTask(SiteManager.this,
                        _address, _username, _password, _port,  new MyInterface() {
    @Override
    public void myMethod(boolean result) {
        if (result == true) {
            Toast.makeText(SiteManager.this, "Connection Succesful",
            Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(SiteManager.this, "Connection Failed:" + status, Toast.LENGTH_LONG).show();
        } 
    }
});

task.execute();