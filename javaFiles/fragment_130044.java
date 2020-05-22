public interface NewsDowloader
{
    String download();
}

public class FastNewsDownloader
    implements NewsFownloader
{
    public String download() { /* ... */ }
}

public class NormalNewsDownloader
    implements NewsFownloader
{
    public String download() { /* ... */ }
}

public class SlowNewsDownloader
    implements NewsFownloader
{
    public String download() { /* ... */ }
}