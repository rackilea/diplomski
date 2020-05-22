package com.example.teststack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

public class Webpage extends Activity {
    WebView webView;

    final String mimeType = "text/html";

    final String encoding = "utf-8";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webpage);
        Intent webPageIntent = getIntent();
        String htmlSource = webPageIntent.getStringExtra("source");
        webView = (WebView) findViewById(R.id.webview);
        webView.loadData(htmlSource, mimeType, encoding);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_webpage, menu);
        return true;
    }
}