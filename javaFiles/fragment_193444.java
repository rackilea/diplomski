private class CustomJavaScriptInterface {

    @JavascriptInterface
    public void html(final String html) {
        //Your HTML is here
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setTextHtml(html);
            }
        });
        Log.e("HTML Length", Integer.toString(html.length()));
    }
}

private void setTextHtml(String html) {
    textview1.setText(html);
}