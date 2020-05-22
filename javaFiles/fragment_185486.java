public static void main(String[] args) throws IOException
{
    String url = "http://www.juventus.com/wps/poc?uri=wcm:oid:91da6dbb-4089-49c0-a1df-3a56671b7020";

    Document document = manualRedirectHandler(url);

    Elements elements = document.getElementsByClass("juveShareImage");

    for (Element element : elements)
    {
        System.out.println(element.attr("src"));
    }

}

private static Document manualRedirectHandler(String url) throws IOException
{
    Response response = Jsoup.connect(url.replaceAll(" ", "%20")).followRedirects(false).execute();
    int status = response.statusCode();

    if (status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_SEE_OTHER)
    {
        String redirectUrl = response.header("location");
        System.out.println("Redirect to: " + redirectUrl);
        return manuelRedirectHandler(redirectUrl);
    }

    return Jsoup.parse(response.body());
}