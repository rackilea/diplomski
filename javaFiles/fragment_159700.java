class JSONTask extends AsyncTask<String ,String,String>{
private TextView textView;

public JSONTask(TextView textView) {
    this.textView = textView;
}

@Override
protected String doInBackground(String... params) {
    return null;
}

@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);
    textView.setText(s);
}