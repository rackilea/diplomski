public static void main(String[] args) {

    Document doc;
    try {

        // need http protocol
        doc = Jsoup.connect("http://www.skyovnis.com/category/ufology/").userAgent("Mozilla").get();
        // get page title
        String title = doc.title();
        System.out.println("title : " + title);

        // get all links (this is what you want)
        Elements links = doc.select("a[href]");
        for (Element link : links) {

            // get the value from href attribute
            System.out.println("\nlink : " + link.attr("href"));
            System.out.println("text : " + link.text());

        }

    } catch (IOException e) {
        e.printStackTrace();
    }

  }