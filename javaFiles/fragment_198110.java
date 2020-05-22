SingletonClass appIDSingleton = SingletonClass.getInstance();
    appIDSingleton.getAppID(new AppIdDownloadListener() {

        @Override
        public void appIDAvailable(String appId) {
            this.ID = appId; 
        }
    });


public void getAppID(AppIdDownloadListener listener) {
    try {
        new DownloadAppID(listener).execute(APP_ID_URL).get(5000, TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (TimeoutException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public interface AppIdDownloadListener {
    public void appIDAvailable(String appId);
}

private class DownloadAppID extends AsyncTask<String, Void, String> {

    private AppIdDownloadListener listener;

    public DownloadAppID(AppIdDownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        /* Your stuff here */
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println(result);
        listener.appIDAvailable(result);
    }
}