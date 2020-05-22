@Root(name = "rss", strict = false)
public class Feed implements Serializable {
@Element(name = "channel")
private Channel mChannel;

public Channel getmChannel() {
    return mChannel;
}

public Feed() {
}

public Feed(Channel mChannel) {
    this.mChannel = mChannel;
}
}