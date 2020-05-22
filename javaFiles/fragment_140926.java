boolean doubleBack = false;
@Override
public void onBackPressed() {
    if (mWebView.canGoBack()) {
        mWebView.goBack();
        return ;
    }

    if (doubleBack) {
        super.onBackPressed();
        return;
    }

    doubleBack = true;
    Toast.makeText(this, "Click once more to Exit the app", Toast.LENGTH_SHORT).show();

    new Handler().postDelayed(new Runnable() {

        @Override
        public void run() {
            doubleBack = false;                       
        }
    }, 2000);
}