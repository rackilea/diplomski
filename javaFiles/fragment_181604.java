public class DownloadFiles extends AsyncTask<URL, Void, Void> {

  Context ctx;

  DownloadFiles(Context ctx) {
    this.ctx = ctx;
  }

  @Override
  public void doInBackground(URL... urls) {
    // ...
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
    // ...
  }
}