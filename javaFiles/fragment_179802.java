final String html = "<div class=\"teaser-img\">\n"
        + "    <a href=\"/julien/blog/failure-consciousness-vs-success-consciousness-shifting-focus-become-badass-or-loser\">\n"
        + "        <img src=\"http://www.rsdnation.com/files/imagecache/blog_thumbnail/files/blog_thumbs/rsdnatonaustin.jpg\" alt=\"\" title=\"\"/>\n"
        + "    </a>\n"
        + "</div>";

// Parse the html from string or eg. connect to a website using connect()
Document doc = Jsoup.parseBodyFragment(html);

for( Element element : doc.select("div.teaser-img img[src]") )
{
    System.out.println(element);
}