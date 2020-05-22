class InternetTask extends AsyncTask<Void, Void, Boolean>{
    private MainActivity activity;

    InternetTask(MainActivity activity){
        this.activity = activity;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        int statusCode = -1;
        try{
            URL url = new URL("http://www.google.com/humans.txt");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            statusCode = http.getResponseCode();
            http.disconnect();
        } catch (MalformedURLException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        if (statusCode == HttpURLConnection.HTTP_OK) {
            return true;
        }
        else
        {
            //connection is not OK
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        activity.receiveMagic(aBoolean);
    }
}