import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LinkActivity extends Activity {

EditText txtLink;
Button btnOpenLink;
String defaultLink;
WebView mWebView;
String mUrl = "";
SharedPreferences mPrefs;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_link);

    mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    defaultLink = "http://www.google.com";

    mWebView = (WebView) findViewById(R.id.web_view);
    txtLink = (EditText) findViewById(R.id.editTextLink);
    btnOpenLink = (Button) findViewById(R.id.buttonOpenLink);
    btnOpenLink.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            String page = txtLink.getText().toString();
            if(!TextUtils.isEmpty(page)){
                mUrl = defaultLink+"/"+page;
                mWebView.loadUrl(url);
            }else{
                Toast.makeText(LinkActivity.this, "Please enter page on editText!!", Toast.LENGTH_LONG).show();
            }
        }
    });
}

// This method will reloads the last opened page in the web view..!
@Override
protected void onResume()
{
    super.onResume();
    String url = mPrefs.getString("url", "");

    if (!url.equalsignorecase(""))
    {
        mUrl = url;
        txtLink.setText(url);
        mWebView.loadUrl(url);
    }
}

// And this will save the last loaded link in the Shared Preferences(Local Storage)
@Override
protected void onPause()
{
    super.onPause();
    mPrefs.edit().putString("url", mUrl).commit();
}
}