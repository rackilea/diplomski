public static void main(String[] args) {
    String html = "<td class=\"my class\" >\n" +
            "      <div class=\"content\" style=\"margin-left:10px;\">\n" +
            "        <ul style=\"list-style-type: disc;\">\n" +
            "           <li><span>obj: blue</span></li>\n" +
            "          <li><span>descr: red</span></li>\n" +
            "          <li><span>double: yellow</span></li>\n" +
            "        </ul>\n" +
            "      </div>\n" +
            "</td>";

    Elements select = Jsoup.parse(html).select("div > ul > li > span");
    for (Element element : select) {
        System.out.println(element.text());
    }
}