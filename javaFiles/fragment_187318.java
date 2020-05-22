package com.myworldrules.apps.lifehacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
private WebView view;
@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String url = "http://hacks.myworldrules.com";
    view=(WebView) this.findViewById(R.id.webView);
    view.clearCache(true);
    WebSettings webSettings = view.getSettings();
    webSettings.setJavaScriptEnabled(true);
    webSettings.setDomStorageEnabled(true);
    webSettings.setAppCacheEnabled(false);
    view.loadUrl(url);


    view.setWebViewClient(new WebViewClient());

}

}