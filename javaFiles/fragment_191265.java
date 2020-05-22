Element iframe = doc.select("iframe").first();
String iframeSrc = iframe.attr("src");

if(iframeSrc != null) {
    iframeContentDoc = Jsoup.connect(iframeSrc).get();
}