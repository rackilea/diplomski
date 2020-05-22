class RequestTask extends AsyncTask<String, String, String> {

    TextView textView = null;

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    ...

    @Override
    protected void onPostExecute(String result) {
        if (textView != null) {
            textView.setText(result);
        }
    }
}