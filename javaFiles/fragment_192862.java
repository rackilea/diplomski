File f = new File("D:\\Projects\\Java\\report.html");

Document doc = Jsoup.parse(f, null, ""); // set proper Charset (2nd param) and BaseUri (3rd param) here
Elements elements = doc.select("img[src]");

for( Element element : elements )
{
    // Do something with your links here ...
    System.out.println(element.attr("src"));
}