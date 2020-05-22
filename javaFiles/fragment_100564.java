//onCreate
final WebView engine = (WebView) findViewById(R.id.web_engine);
engine.loadUrl("file:///android_asset/www/index.html");
engine.getSettings().setJavaScriptEnabled(true);

//onResume
boolean refresh = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("SHOULD_REFRESH", false)
if (refresh) {
  engine.loadUrl("javascript:window.location.reload();");
  //remove the shared preference here or set it to false to prevent reloading next time
}