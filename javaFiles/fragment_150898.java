//for ArrayList; other appropriate methods if idToQuery is not ArrayList
int count = idToQuery.size();
int index = 0;

private void loadWebView() {
webView = new WebView(ctx);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.addJavascriptInterface(new getDataJSForPrint(), "Android");

    webView.setWebViewClient(new WebViewClient(){
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            String someJsonData = "Lot of Data"; //only for example

            //init function use data to fill form in webpage
            webView.loadUrl("javascript:init(" + someJsonData+ ")");

            //get html String from WebView when finished to load                
            webView.loadUrl("javascript:window.Android.getHtmlFromWebView('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
    });

    webView.loadUrl("file:///android_asset/index.html");
}

//Call the loadWebView function again after the bitmap operation. Increment the index each time. Then you can compare it with total count to control how many times you wan to call    loadWebView function
public class getDataJSForPrint{

        @JavascriptInterface
        public void getHtmlFromWebView (String html) throws DocumentException, IOException{

            //got this piece of code in another answer of stackoverflow
            File imageTemp = new File (Environment.getExternalStorageDirectory(), "tmpImag.jpeg");

            webView.measure(MeasureSpec.makeMeasureSpec(
                    MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED),
                    MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            webView.layout(0, 0, webView.getMeasuredWidth(),
                    webView.getMeasuredHeight());
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache();

            Bitmap bm = Bitmap.createBitmap(webView.getMeasuredWidth(),
                    webView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

            Canvas bigcanvas = new Canvas(bm);
            Paint paint = new Paint();
            int iHeight = bm.getHeight();

            bigcanvas.drawBitmap(bm, 0, iHeight, paint);
            webView.draw(bigcanvas);


            if (bm != null) {
                try {
                    OutputStream fOut = null;
                    fOut = new FileOutputStream(imageTemp);

                    bm.compress(Bitmap.CompressFormat.JPEG, 50, fOut);
                    fOut.flush();
                    fOut.close();
                    bm.recycle();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            index++;
            if (index < count) {
                loadWebView()
            }


        }

    }