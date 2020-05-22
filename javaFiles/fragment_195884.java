if (c != null) {
    c.moveToFirst();
    List<RssItem> rssss = new ArrayList<RssItem>();
    for (int k = 0; k < c.getCount(); k++) {
        RssItem rss = new RssItem();
        // depending on the order of your columns.
        rss.name = cursor.getString(0);
        rss.xxxx = cursor.getInt(xxx);
        rssss.add(rss);
    }
    c.close();
}