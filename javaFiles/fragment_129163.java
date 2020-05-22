public class PostDataThread extends AsyncTask<Void, Void, Integer> {

  String [] data;
  Context context;
  int res = 0;

  public PostDataThread(int type, String data[], Context c) {
    this.data = data;
    this.context = c;
  }

  @Override
  protected Void doInBackground(Void... params) {
    Connect c = new Connect();
    c.start(Constant.RECEIVED_MESSAGE, data, context);
    res = 444;
    return res;
  }

  @Override
  protected void onPostExecute(Integer result) {
    Log.d(TAG, "Result is: " +result);
  }

}