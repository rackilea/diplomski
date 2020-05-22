try {
    document = Jsoup.connect("http://www.malformedurl.com").get();
    // ...
} catch (UnknownHostException e) {
    System.err.println("Unknown host");
    e.printStackTrace(); // I'd rather (re)throw it though.
}