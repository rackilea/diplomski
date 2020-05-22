public class Test {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.golem.de/").get();
            Elements imageElements = doc.getElementsByTag("img");
            for (Element element : imageElements) {
                System.out.println("src: "+element.attr("src"));
                System.out.println("title: "+element.attr("title"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}