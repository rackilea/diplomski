String url = "http://www.google.com";
List<String> images = new ArrayList<String>();
Document doc = Jsoup.connect(url).get();
Elements img = doc.select("img");
for (Element el : img)
{
    String imageUrl = el.attr("src");
    images.add(imageUrl);
}