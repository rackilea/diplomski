class MyTask extends AsyncTask<URL,String,ArrayList<Blogs>> {
    // Listener member variable.
    private OnJSONParsedListener mOnJSONParsedListener;

    @Override
    protected ArrayList<Blog> doInBackground(URL... params) {
        // Parse JSON.
        ArrayList<Blogs> blogsList = parseJSON(response);

        // Pass the blogs list to the onPostExecute method.
        return blogsList;
    }

    @Override
    protected void onPostExecute(ArrayList<Blogs> blogsList) {
        // Invoke listener, if present.
        if (mOnJSONParsedListener != null)
            mOnJSONParsedListener.onJSONParsed(blogsList);
    }

    // Listener interface.
    public interface OnJSONParsedListener {
        void onJSONParsed(ArrayList<Blogs> blogsList);
    }

    // Setter for listener interface member variable.
    public void setOnJSONParsedListener(OnJSONParsedListener listener) {
        mOnJSONParsedListener = listener;
    }
}