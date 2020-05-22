import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User: lihongxu
 * Date: 17/6/13
 * Time: 19:42
 * Comments
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("D:\\ref.txt"));

        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
            {
                for (String Z : list) {
                    System.out.println(Z);

                }
            }
        }
        s.close();// LIST completed


        // code to download the paper from scholar
        for (String query : list) {
            try {
                Document doc = Jsoup
                        .connect("https://scholar.google.com.pk/scholar?q=" + query)
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like " +
                                "Gecko)" +
                                " Chrome/33.0.1750.152 Safari/537.36")
                        .get();

                String title = doc.title();
                System.out.println("title : " + title);


                Elements links = doc.select("div.gs_ggsd").select("a[href]");
                //Element  = doc.select("div.gs_ggs gs_fl").first();

                for (Element link : links) {
                    //System.out.println("\nlink : " + link.attr("href"));
                    URL website = new URL(link.attr("href"));
                    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                    FileOutputStream fos = new FileOutputStream("D:\\paper.pdf");
                    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                }
                // System.out.println("text : " + link.text());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}