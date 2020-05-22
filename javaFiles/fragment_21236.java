public class NewClass {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.vremea.net/").get();
            Elements e = doc.select(".homeContent>ul>li ");
            PrintStream ps = new PrintStream(new FileOutputStream("io"));
            for (int i = 0; i < e.size(); i++) {
                ps.println(e.get(i).text());
                System.out.println(e.get(i).text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}