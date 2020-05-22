Button openPdfBtn = new Button(this); //this is not gonna be visible
yourWebView.addJavascriptInterface(openPdfBtn, "openPdfBtn"); //here you bind the js with the native button
openPdfBtn.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        openPdf();
    }
});