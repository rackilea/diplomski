WebView DisclaimerWebView = ((WebView) findViewById(R.id.disclaimer_info));
DisclaimerWebView.loadData(
    "<html><head><meta charset=\"ISO-8859-1\" /></head><body><div align=\"justify\">"
        + LanguageUtil.getText(LanguageUtil.label_DisclText)
        + "</div></body></html>",
    "text/html; charset=UTF-8", null);