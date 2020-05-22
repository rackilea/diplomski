public class CloudPhoneAppActivity extends DroidGap {
private class NoScaleWebViewClient extends GapViewClient {

    public NoScaleWebViewClient(DroidGap ctx) {
        super(ctx);
        myApp.ctx = ctx;
    }

    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        Log.d("NoScaleWebViewClient", "Scale changed: " + String.valueOf(oldScale) + " => " + String.valueOf(newScale));
    }
}
/** other stuff after**/ 
}