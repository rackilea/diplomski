try
{
    mClient = new MobileServiceClient(
        "https://myurl.azure-mobile.net/",
        "my_secret_squirrel_key",
        this);
}
catch(MalformedUrlException ex)
{
    Log.e("Service URL was malformed!", ex);
}