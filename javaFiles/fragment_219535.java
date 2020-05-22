public static void getNames() throws IOException {

    String url = "http://download.cyanogenmod.org/?device=d855";
    print("Fetching %s...", url);

    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a");

    Set<String> downloadNames = new HashSet<>();

    // print("\nLinks: (%d)", links.size());
    for (Element link : links) {
        downloadNames.add(print("(%s)", trim(link.text(), 35)));
    }

    for (String element : downloadNames) {
        System.out.println(element);
    }

}