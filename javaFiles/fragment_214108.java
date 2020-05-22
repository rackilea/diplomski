public static void main(String[] args) throws Exception {

    URI uri = URI.create("http://www.amerisourcebergendrug.com");

    Document d = Jsoup.connect(uri.toString()).get();

    for (Element refresh : d.select("html head meta[http-equiv=refresh]")) {

        Matcher m = Pattern.compile("(?si)\\d+;\\s*url=(.+)|\\d+")
                           .matcher(refresh.attr("content"));

        // find the first one that is valid
        if (m.matches()) {
            if (m.group(1) != null)
                d = Jsoup.connect(uri.resolve(m.group(1)).toString()).get();
            break;
        }
    }
}