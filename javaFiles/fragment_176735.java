String link = "http://torrage.com/torrent/13764753227BCBE3E8E82C058A7D5CE2BDDF9857.torrent";
String path = "/Users/Bob/Documents";
URL website = new URL(link);
try (InputStream is = new GZIPInputStream(website.openStream())) {
    Files.copy(is, Paths.get(path + File.separator + "t2.torrent"));
    is.close();
}