webView = (WebView) findViewById(R.id.webView1);
webView.getSettings().setJavaScriptEnabled(true);
webView.loadUrl("https://parivahan.gov.in/rcdlstatus/vahan/rcstatus.xhtml");
webView.setWebViewClient(new WebViewClient() {
  public void onPageFinished(WebView view, String url) {
    String reg1 = "KA51X";
    String reg2 = "2442";
    if (isFirstLoad) {
      webView.loadUrl("javascript: {" +
        "document.getElementById('convVeh_Form:tf_reg_no1').value = '" + reg1 + "';" +
        "document.getElementById('convVeh_Form:tf_reg_no2').value = '" + reg2 + "';" +
        "document.querySelector('[id=\"convVeh_Form:j_idt27\"]').click(); };");

      isFirstLoad = false;
    }
  }
});