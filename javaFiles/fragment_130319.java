public class jsTesting {
    public static void main(String[] args) {
        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link and after that is a second link called <a href='http://example2.com/'><b>example2</b></a></p>";
        Elements links = Jsoup.parse(html).select("a[href]"); // a with href;
        for (Element link : links) {
            //Do whatever you want here
            System.out.println("Link Attr : " + link.attr("abs:href"));
            System.out.println("Link Text : " + link.text());    
        }       
    }
}