static void do_page(int id) throws IOException {
    Document doc = Jsoup.connect("https://xkcd.com/" + id).get();
    Elements imgs = doc.select("#comic img");
    for (Element e: imgs) {
        System.out.println(e.attr("src"));
    }
}