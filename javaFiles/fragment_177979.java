public class MyDownloadListener : Java.Lang.Object, IDownloadListener
{
    public void OnDownloadStart(string url, string userAgent, string contentDisposition, string mimetype, long contentLength)
    {
        Console.WriteLine(url);
    }
}