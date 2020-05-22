import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

@SuppressLint("SetJavaScriptEnabled")

public class MainActivity extends ActionBarActivity {

private WebView view;
private ProgressBar progressBar;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maine);

    progressBar = (ProgressBar) this.findViewById(R.id.progressBar1);
    String url = "http://www.carsaleindiaofficial.com/?m=1";
    view = (WebView) this.findViewById(R.id.webView1);
    view.setWebViewClient(new MyAppWebViewClient());
    view.getSettings().setJavaScriptEnabled(true);
    view.getSettings().setDomStorageEnabled(true);
    //view.loadUrl(url);
    view.loadUrl("http://m.facebook.com/");
   // view.loadUrl("file:///android_asset/web.html");

}

public class MyAppWebViewClient extends WebViewClient {

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        //view.findViewById(R.id.progressBar1).setVisibility(View.GONE);
        Log.i("pageFinished", "yesss");
        progressBar.setVisibility(View.INVISIBLE);
        //progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
       view.loadUrl(url);
       return true;
    }

}


@Override
public void onBackPressed() {
    if (view.canGoBack()) {
        view.goBack();
    } else {
        super.onBackPressed();
    }
}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.maine, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.action_settings)
        view.loadUrl(view.getUrl());

    return super.onOptionsItemSelected(item);
    }
}