String html = "<iframe src='demo_iframe.htm' height='200' width='300'></iframe>";
    Document doc = Jsoup.parse(html);
    Element iframe = doc.select("iframe").first();
    String iframeSrc = iframe.attr("src");
    String height = iframe.attr("height");
    String width = iframe.attr("width");
    System.out.println(iframeSrc + " height:" + height + " width:" + width);