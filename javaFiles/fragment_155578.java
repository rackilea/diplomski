import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


....

while(sc.hasNext())
        {
            String line=sc.nextLine();
            if(line.contains("LANTALK")){
               Document doc = Jsoup.parse(line);
               Element  msg = doc.select("MSGTEXT").first();
               System.out.println(msg.text());
            }
                System.out.println(line);
        } // End of while
    .....