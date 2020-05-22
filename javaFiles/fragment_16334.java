private Context context;

public myWebClient(Context context) {
   this.context = context;
}

@Override
public void onPageFinished(WebView view, String url) {
 .....

     SharedPreferences.Editor prefs = PreferenceManager.getDefaultSharedPreferences(context).edit();

}