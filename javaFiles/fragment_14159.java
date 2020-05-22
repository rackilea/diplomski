package ru.unatco.rss.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "rss", strict = false)
public class Feed {
    @Element(name = "channel")
    private Channel mChannel;

    public Channel getmChannel() {
        return mChannel;
    }
}

package ru.unatco.rss.data;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.unatco.rss.model.Item;

@Root(name = "channel", strict = false)
public class Channel {
    @ElementList(inline = true)
    private List<FeedItem> mFeedItems;

    public List<FeedItem> getFeedItems() {
        return mFeedItems;
    }
}

package ru.unatco.rss.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import ru.unatco.rss.model.Item;

@Root(name = "item", strict = false)
public class FeedItem {
    @Element(name = "title")
    private String mTitle;
    @Element(name = "description")
    private String mDescription;

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }
}