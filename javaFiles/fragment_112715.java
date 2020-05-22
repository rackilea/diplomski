import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LyricsParser {

    public static void main(String[] args) throws Exception {

        String SEARCH_STRING = "Madonna";
        String URL = "http://www.lyricsfreak.com/search.php?a=search&type=song&q=";

        List<String> artists = new ArrayList<String>();
        List<String> songs = new ArrayList<String>();
        List<String> hits = new ArrayList<String>();

        Document doc = Jsoup.connect(URL + SEARCH_STRING)
                .referrer(URL + SEARCH_STRING).get();

        for(Element tracks : doc.select("td.colfirst")){
            for(Element links : tracks.getElementsByTag("a")){
                artists.add(links.text());
            }
        }

        for(Element tracks : doc.select("td > a.song")){
            for(Element links : tracks.getElementsByTag("a")){
                songs.add(links.text());
            }
        }

        for(Element tracks : doc.select("td.colast")){
            hits.add(tracks.text());
        }

        int length = artists.size();
        for(int i=0; i<length; i++){
            System.out.println("[" + artists.get(i) + ",\t" + songs.get(i) + ",\t" + hits.get(i+1) + "]");
        }
    }

}