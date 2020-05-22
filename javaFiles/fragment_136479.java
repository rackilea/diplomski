try {
    document = Jsoup.connect("http://12.34.56.78").get();
    // ...
} catch (SocketTimeoutException e) {
    System.err.println("IP cannot be reached");
    e.printStackTrace(); // I'd rather (re)throw it though.
}