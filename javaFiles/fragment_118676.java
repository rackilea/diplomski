@Override
public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (Uri.parse(url).getHost().equals("www.example.com")) {
        // This is your web site, so do not override; let WebView load the page
        return false;
    }
    // Otherwise, the link is not for a page on your site, so launch another Activity that handles URLs
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    startActivity(intent);
    return true;
}