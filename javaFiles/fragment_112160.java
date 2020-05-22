class Feeds {
    private Map<String, String> feed;

    public Feeds() {}

    public String getName() {
        return feed.get("name");
    }
}