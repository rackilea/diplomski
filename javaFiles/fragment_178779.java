import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;

import static com.d4rkunicorn.partyhard.R.id.webView;


public class MainActivity extends ActionBarActivity {

     WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = new WebView(this);
        setContentView(webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("url");

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                webview.reload();

            }
        });
    }

}