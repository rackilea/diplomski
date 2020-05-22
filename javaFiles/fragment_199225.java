public class Exractor {
    public static void main(String[] args) throws IOException {
        Document d = Jsoup.connect("https://www.brainyquote.com/topics").get();
        Elements e = d.select("div.col-md-4");
        for(Element el : e){
            Elements names = el.getElementsByTag("a"); //getElementsByTag returns elements
        for(Element name: names) {
            String text = name.text();
            System.out.println(text);
            }
        }
    }
}