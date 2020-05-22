public class Test {
    public static void main(String[] args) {

        String s = "<a title=\"%this%Content 3 - Java Programming\" href=\"javascript:;\" onclick=\"data('content_3');\">\n" +
                "Java Programming<span style=\"font-size:10px;color:#D39D96\"></span>\n" +
                "</a></div>\n" +
                "<div class=\"clear\"></div>\n" +
                "<div style=\"display: none;font-size:14px;font-weight:bold;color:red;margin:10px;\" id=\"content_3\">%this%Content 3 Text</div>";
        Document document = Jsoup.parse(s);
        Element element = document.select("a").first();
        String linkHref = element.attr("title");
        System.out.println(linkHref + document.select("div").last().text());


    }
}