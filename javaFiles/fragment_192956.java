public static void main(String args[]) {
    String text = "Some content which contains link as &lt;A HREF=\"/relative-path/fruit.cgi?param1=abc&amp;param2=xyz\"&gt;URL Label&lt;/A&gt; and some text after it and another link &lt;A HREF=\"/relative-path/vegetables.cgi?param1=abc&amp;param2=xyz\"&gt;URL2 Label&lt;/A&gt; and some more text";
    text = StringEscapeUtils.unescapeHtml4(text);
    Pattern p = Pattern.compile("<a href=\"(.*?)\">(.*?)</a>", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(text);
    while (m.find()) {
        text = text.replace(m.group(0), cleanUrlPart(m.group(1), m.group(2)));
    }
    System.out.println(text);
}

private static String cleanUrlPart(String url, String label) {
    if (!url.startsWith("http") && !url.startsWith("www")) {
        if (url.startsWith("/")) {
            url = "http://www.google.com" + url;
        } else {
            url = "http://www.google.com/" + url;
        }
    }
    url = appendQueryParams(url, "myParam=pqr").toString();
    if (label != null && !label.isEmpty()) url += " (" + label + ")";
    return url;
}