import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class NewsCrawler
{
    public NewsCrawler()
    {
        URL url = new URL("https://news.google.com/news/section?topic=t&ned=es&output=rss");
        XmlReader reader = null;

        try
        {
            reader = new XmlReader(url);
            SyndFeed feed = new SyndFeedInput().build(reader);

            for (Iterator i = feed.getEntries().iterator(); i.hasNext();)
            {
                SyndEntry entry = (SyndEntry) i.next();
                System.out.println("Title: " + entry.getTitle());
                System.out.println("   Description: " + Jsoup.parse(entry.getDescription().getValue()).text());
                System.out.println("   Date: " + entry.getPublishedDate());
                System.out.println("   Link: " + entry.getLink());
            }
        }
        finally
        {
            if (reader != null)
            {
                reader.close();
            }
        }
    }
}