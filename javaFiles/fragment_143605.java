InputStream is = null;
try{
    URL page = new URL("http://example.com/");
    URLConnection connection = page.openConnection();
    is = connection.getInputStream();
}
catch(MalformedURLException e)
{
    // ....
}
catch(IOException e)
{
    // Couldn't connect to website
}
// do something with input stream