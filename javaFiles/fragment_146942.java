// Parse your HTML:
// 1. From string:
Document doc = JSoup.parse(htmlAsString);

// 2. Or from an URL:
Document doc = JSoup.connect("http://my.awesome.site.com/").get();

// Then select images inside it:
Elements images = doc.select("img");

// Then iterate
for (Element el : images) {
    String imageUrl = el.attr("src");

    // TODO: Do something with the URL
}