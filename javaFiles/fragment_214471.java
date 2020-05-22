import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndLinkImpl;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Rome {

    public static void main(String[] args) {
        try {
            URLConnection urlConnection = new URL("https://www.google.com/search?hl=en&q=robbery&tbm=blg&output=atom").openConnection();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            SyndFeedInput input = new SyndFeedInput();
            input.setPreserveWireFeed(true);
            SyndFeed feed = input.build(new XmlReader(urlConnection));
            System.out.println("Feed Title: " + feed.getTitle());
            for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
                System.out.println("Title: " + entry.getTitle());
                System.out.println("Unique Identifier: " + entry.getUri());
                System.out.println("Updated Date: " + entry.getUpdatedDate());
                for (SyndLinkImpl link : (List<SyndLinkImpl>) entry.getLinks()) {
                    System.out.println("Link: " + link.getHref());
                }
                for (SyndContentImpl content : (List<SyndContentImpl>) entry.getContents()) {
                    System.out.println("Content: " + content.getValue());
                }

                for (SyndCategoryImpl category : (List<SyndCategoryImpl>) entry.getCategories()) {
                    System.out.println("Category: " + category.getName());
                }
            }// for
        }// try
        catch (Exception ex) {
            System.err.println(ex);
        }

    }
}