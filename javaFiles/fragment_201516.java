for (int i = 0 ; i < 5 ; i++) {
        entry = (SyndEntry) feed.getEntries().get(i);
        BroadcastItem item = new BroadcastItem();

        item.setMessage(entry.getTitle());
        item.setLinkUrl(entry.getLink());

        session.save(item);
    }