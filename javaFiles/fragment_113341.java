package com.mobiinteractive.Sandbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SandbarinFacebook extends Activity {

WebView mWebView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fb);

        final ProgressDialog pd = ProgressDialog.show(this, "", "Loading...",
                true);

        mWebView = (WebView) findViewById(R.id.webkitWebView1);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);  
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if(pd.isShowing() && pd!=null)
                {
                pd.dismiss();
                }
            }
        });
        mWebView.loadUrl("http://m.facebook.com/sandbarathens");

    }
}