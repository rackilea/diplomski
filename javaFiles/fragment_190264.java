@Root(name = "channel", strict = false)
public class Channel implements Serializable {
@ElementList(inline = true, name="item")
private List<FeedItem> mFeedItems;

public List<FeedItem> getFeedItems() {
    return mFeedItems;
}

public Channel() {
}

public Channel(List<FeedItem> mFeedItems) {
    this.mFeedItems = mFeedItems;
}
}