String html = "xyz xyx xyz<br /><img style=\"max-width: 100%;\" src=\"https://blablab.png\" alt=\"Loading...\" /></p>abc</p><img style=\"max-width: 100%;\" src=\"https://blablab2.png\" alt=\"Loading...\" /><div>abc</div><img style=\"max-width: 100%;\" src=\"https://blablab3.png\" alt=\"Loading...\" />";
Document document = Jsoup.parse(html);
Elements imgs = document.select("img[src]");
for (Element img : imgs) {
  img.attr("src", "http://placehold.it/350x150");
}
String newHtml = document.html();