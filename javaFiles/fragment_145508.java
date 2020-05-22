public static void main(String[] args) throws Exception {
    String url = "http://uat.sophiejuliete.com.br/tendencias/";
    Document document = Jsoup.connect(url).timeout(10000).get();
    // Using Elements to get the Meta data
    Elements description = document.select("div[class=postContent]");
    // Locate the content attribute
    String desc = description.text();
    System.out.println(desc);
    // prints out "Agarradinhos às orelhas, os solitários e brincos..."
}