public enum DeviceType {
    RWFORUM("http://rootzwiki.com/forum/"),
    TORO("362-cdma-galaxy-nexus-developer-forum");

    private final String forumUrl;

    private DeviceType(String forumUrl) {
        this.forumUrl = forumUrl;
    }

    public String getForumUrl() {
        return forumUrl;
    }
}