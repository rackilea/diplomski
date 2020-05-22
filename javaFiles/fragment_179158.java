public class StoryAbstract extends JsonModel{

private static final long serialVersionUID = 1269037550260848268L;

@SerializedName("id")
private long id;

@SerializedName("title")
private String title;

@SerializedName("isBreaking")
private int isBreaking;

@SerializedName("updated")
private long updated;

@SerializedName("readers")
private long readers;

@SerializedName("feed")
private Feed feed;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public int getIsBreaking() {
    return isBreaking;
}

public void setIsBreaking(int isBreaking) {
    this.isBreaking = isBreaking;
}

public long getUpdated() {
    return updated;
}

public void setUpdated(long updated) {
    this.updated = updated;
}

public long getReaders() {
    return readers;
}

public void setReaders(long readers) {
    this.readers = readers;
}

public Feed getFeed() {
    return feed;
}

public void setFeed(Feed feed) {
    this.feed = feed;
}