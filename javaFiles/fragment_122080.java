String partialHtml = "<html><head><meta something=\"something\">";
Document document = Jsoup.parse(partialHtml);
Elements values = document.getElementsByAttribute("something");
for (Element el : values) {
    System.out.println(el.attr("something"));
}