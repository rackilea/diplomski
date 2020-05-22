package com.example.project;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebActivity extends Activity {

    private WebView wv;

    private String LASTURL = "";

    Menu myMenu = null;
    private ProgressDialog dialog;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);

        if (!InternetConnection.checkNetworkConnection(this)) {
            showAlert(this, "No Data Connection", "This Application requires an internet connection");
        } else {

            setContentView(R.layout.web_view);

            wv = (WebView) findViewById(R.id.web_view);

            WebSettings webSettings = wv.getSettings();
            webSettings.setSavePassword(true);
            webSettings.setSaveFormData(true);
            webSettings.setJavaScriptEnabled(true);
            webSettings.setUseWideViewPort(true);
            webSettings.setLoadWithOverviewMode(true);
            webSettings.setSupportZoom(false);


            final Activity activity = this;

            // start ProgressDialog with "Page loading..."
            dialog = new ProgressDialog(activity);
            dialog.setMessage("Page loading...");
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();

            wv.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    // set address bar and progress
                    // activity.setTitle( " " + LASTURL );
                    // activity.setProgress( progress * 100 );

                    if (progress == 100) {
                        // stop ProgressDialog after loading
                        dialog.dismiss();

                        // activity.setTitle( " " + LASTURL );
                    }
                }
            });

            wv.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode,
                        String description, String failingUrl) {
                    Toast.makeText(getApplicationContext(),
                            "Error: " + description + " " + failingUrl,
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url.indexOf("google") <= 0) {
                        // the link is not for a page on my site, so launch
                        // another Activity that handles URLs
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri
                                .parse(url));
                        startActivity(intent);
                        return true;
                    }
                    return false;
                }
                /*****************************************************************/
                /*  Here the load of the page will start so we must launch the  */
                /*  ProgressDialog                                              */
                /*****************************************************************/                                             
                public void onPageStarted(WebView view, String url,
                        Bitmap favicon) {

                    // this is what we should do
                    dialog.setMessage("Page loading...");
                    dialog.setIndeterminate(true);
                    dialog.setCancelable(true);
                    dialog.show();
                    //
                    LASTURL = url;
                    view.getSettings().setLoadsImagesAutomatically(true);
                    view.getSettings().setBuiltInZoomControls(true);
                }
                /*****************************************************************/
                /*  Here the load of the page will stop so we must dismiss the  */
                /*  ProgressDialog                                              */
                /*****************************************************************/ 
                public void onPageFinished(WebView view, String url) {
                    // this is what we should do
                    dialog.dismiss();

                }
            });
            wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            wv.setScrollbarFadingEnabled(false);
            wv.loadUrl("http://www.google.com");

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    /*****************************************************************/
    /*  Here is a menu with basic options. Will probably get 
     * comments on how this is replaced by action bar               */
    /*****************************************************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        this.myMenu = menu;
        MenuItem item = menu.add(0, 1, 0, "Home");
        item.setIcon(R.drawable.home);
        MenuItem item2 = menu.add(0, 2, 0, "Back");
        item2.setIcon(R.drawable.arrowleft);
        MenuItem item3 = menu.add(0, 3, 0, "Reload");
        item3.setIcon(R.drawable.s);
        MenuItem item4 = menu.add(0, 4, 0, "Share");
        item4.setIcon(R.drawable.share);
        MenuItem item5 = menu.add(0, 5, 0, "Rate");
        item5.setIcon(R.drawable.vote);
        MenuItem item6 = menu.add(0, 6, 0, "Exit");
        item6.setIcon(R.drawable.close);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case 1:
            wv.loadUrl("http://www.google.com");
            break;
        case 2:
            if (wv.canGoBack()) {
                wv.goBack();
            }
            break;
        case 3:
            wv.loadUrl(LASTURL);
            break;
        case 4:
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("plain/text");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Check out this app I found.");
            startActivity(Intent.createChooser(sharingIntent,"Share using"));
            break;
        case 5:

            Intent marketIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                    "http://market.android.com/details?id=" + getPackageName()));
                  startActivity(marketIntent2);
                break;

        case 6:
            finish();
            break;

        }

        return true;
    }



    /**
     * Display a simple alert dialog with the given text and title.
     * 
     * @param context
     *            Android context in which the dialog should be displayed
     * @param title
     *            Alert dialog title
     * @param text
     *            Alert dialog message
     */
    public void showAlert(Context context, String title, String text) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle( title);

        // set dialog message
        alertDialogBuilder
        .setMessage( text )
        .setCancelable(false)
        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                // if this button is clicked, close
                // current activity
                finish();
            }
        })
        .create().show();

    }
}