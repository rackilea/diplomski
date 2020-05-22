final String RSS_LINK = "rss";
final String OTHER_LINK = "other";

String url1=request.getParameter("source");
String result="";
if (url1 != null && url1.equals(RSS_LINK)) {
    result=p.addURL(url1,source1);
}
else if (url1 != null && url1.equals(OTHER_LINK)) {
    result=p.addURL1(url1,source1);
}