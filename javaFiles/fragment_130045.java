public class NewsReader 
{
    public void getLatestNews(NewsDownloader downloader) 
    {
        downloader.download();
    }
}