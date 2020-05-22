public class NewsDownloaderFactory
{
    public NewsDownloader getNewsDownloader(final Connection c)
    {
        final NewsDownloader downloader;

        if(c.getType().equals("Wifi"))
        {
            downloader = new FastNewsDownloader();
        }
        else if(c.getType().equals("3g"))
        {
            downloader = new NormalNewsDownloader();
        }
        else
        {
            downloader = new SlowNewsDownlaoder();
        }

        return (downloader);
    }  
}