public static void main(String[] args) {
    String text = "<p style=\"text-align: center;\">Center Aligned Text</p>";
    String clean = Jsoup.clean(text, Whitelist.relaxed()
            .addAttributes("p", "style"));
    System.out.println(clean);
}