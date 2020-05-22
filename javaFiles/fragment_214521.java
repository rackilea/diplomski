@Override
public void onPageStarted(WebView view, String url, Bitmap favicon) {
super.onPageStarted(view, url, favicon);
if (url.equals(SUCCESS_URL)) {
Toast.makeText(PayUActvity.this, "Success! ",
Toast.LENGTH_SHORT).show();
SharedPreferences prefs = getSharedPreferences(
AppConstants.PAYMENT_SUCESS, Context.MODE_PRIVATE);
SharedPreferences.Editor editor = prefs.edit();
editor.putString(AppConstants.PAYMENT_SUCESS, "1");
editor.commit();
finish();
} else {
Toast.makeText(PayUActvity.this, "Something Wrong! ",
Toast.LENGTH_SHORT).show();
}
}