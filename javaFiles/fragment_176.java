import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyClass {
    public static void main(String args[]) {
        String html = "<html><head/><body>"+
        "<div class=\"row xyz\"> <div>div1</div> <div>div1_1</div> </div>"+
        "<div class=\"row xws\"> <div>div2</div> </div>" + 
        "<div class=\"row daze\">  <div>div3</div></div>"+
        "</body></html>";
        Document document = Jsoup.parse(html);
        Elements divs = document.select("body > div");//get first level of divs

        for (int i=0; i< divs.size(); i++) {
            System.out.println(String.format("div%d = %s", i + 1, divs.get(i).outerHtml()));
        }
    }
}