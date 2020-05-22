@Override
public boolean launchPDF(WebView view, String url) {
    if ( urlIsPDF(url)){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(url), "application/pdf");
        try{
            view.getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            //user does not have a pdf viewer installed
        }
    } else {
        webview.loadUrl(url);
    }
    return true;
}