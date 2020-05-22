public boolean tryFeed(String feedUrl) throws IOException,MalformedURLException { 
    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = null;
    try {
        feed = input.build(new XmlReader(new URL(feedUrl)));
        return true;
    } catch (FeedException e) {
        // Feed's invalid
        return false;
    }

}