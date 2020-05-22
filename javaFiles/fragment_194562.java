public static void main(String[] args) throws IOException
    {
        String html = "<ul><li><i><a class=\"mw-redirect\" title=\"title1\" href=\"yahoo.com\">used to be a best email</a></i>(1999)</li><li><i><a title=\"title2\" href=\"google.com\">Best search enginee We Will Go</a></i>(1999)</li><li><i><a title=\"title3\" href=\"apple.com\">Best Phone</a></i>(1990)</li></ul>";

        Document doc = Jsoup.parse(html);

        Elements links = doc.select("ul li i a");

        for (Element element : links) {
            System.out.format("%s %s %s\n", element.attr("title"), element.attr("href"), element.text());
        }
    }