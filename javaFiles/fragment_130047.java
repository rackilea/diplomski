public void foo(final Connection c)
{
    final NewsDownloader downloader;
    final NewsReader     reader;

    downloader = NewsDownloaderFactory.getNewsDownloader(c);
    reader = new NewsReader(downlaoder);    
}