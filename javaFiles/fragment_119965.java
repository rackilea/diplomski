private class DownloadXmlTask extends AsyncTask<String, Void, List<StackOverflowXmlParser.Entry>> {
    private Exception mException = null;
    private Context mContext

    public DownloadXmlTask(Context context) {
        mContext = context;
    }

    @Override
    protected List<StackOverflowXmlParser.Entry> doInBackground(String... urls) {
        try {
            return loadXmlFromNetwork(urls[0]);
        } catch (IOException e) {
            mException = e;
        } catch (XmlPullParserException e) {
            mException = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<StackOverflowXmlParser.Entry> results) {
        if (results != null && mException == null) {
          // Do your stuff
          // Rather use mContext as the context for your SimpleAdapter. Injection is always better.
        } else {
            if (mException instanceof IOException){
              //Handle the IOException seperately
            } else if (mException instanceof XmlPullParserException) {
              //Handle the XmlPullParserException seperately
            }
        }
    }
}