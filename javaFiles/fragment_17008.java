private ListClassFragment listFragment;
private String url;
private ProgressDialog dialog;
private final static String TAG = GetJsonFromUrlTask.class.getSimpleName();

public GetJsonFromUrlTask(ListClassFragment listFragment, String url) {
    super();
    this.listFragment = listFragment;
    this.url = url;
}
@Override
protected void onPostExecute(String result) {
    listFragment.parseJsonResponse(result);
    dialog.dismiss();
    Log.i(TAG, result);
}