String url = "www.google.com";
    if (!url.startsWith("http://") && !url.startsWith("https://"))
    {
         url = "http://" + url;
    }
    else
    {
    Intent openUrl = new Intent();
    openUrl.setAction(Intent.ACTION_VIEW);
    openUrl.addCategory(Intent.CATEGORY_BROWSABLE);
    openUrl.setData(Uri.parse(url));      
    startActivity(openUrl);
    }