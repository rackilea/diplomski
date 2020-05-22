BroadcastItem item = new BroadcastItem();

    for (int i = 0 ; i < 5 ; i++) {
        entry = (SyndEntry) feed.getEntries().get(i);

        item.setMessage(entry.getTitle());
        item.setLinkUrl(entry.getLink());

        session.save(item);
    }