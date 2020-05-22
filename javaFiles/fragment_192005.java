import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Sample {
    public static void main(String[] args) throws Exception {
        String html = "<description>"
                        + "&lt;table width='100%' border='0' cellspacing='0' cellpadding='4'&gt;&lt;tr&gt;&lt;td align='left' width='10'&gt;&lt;"
                        + "a href='http://www.3djuegos.com/noticia/145062/0/bioware-nuevo-juego-ip/video-gamescom/trailer/'&gt;&lt;img src='http://i11c.3djuegos.com/juegos/7332/dragon_age_iii/fotos/noticias/dragon_age_iii-2583054.jpg' border='0' width='70' height='52' /&gt;"
                        + "&lt;/a&gt;&lt;/td&gt;&lt;td align='left' valign='top'&gt;Parece ser una nueva licencia creativa, seg&uacute;n lo visto en un enigm&aacu"
                    + "</description>";

        Document doc = Jsoup.parse(html);
        for(Element desc : doc.select("description")){
            String unescapedHtml = desc.text();
            String src = Jsoup.parse(unescapedHtml).select("img").first().attr("src");
            System.out.println(src);
        }
        System.out.println("Done");
    }

}