public void onPageFinished(WebView view, String url) {

    if (url.contains("https://www.amazon.co.uk/gp/yourstore/home")) 
    {
        // Successfully logged in, load your logged in activity
        startActivity(new Intent(this, **yournewclass**.class));
    }

}