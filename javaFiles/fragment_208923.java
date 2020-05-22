public RssReader(String rssUrl, String icon, List<RssItem> rssItems, GetRSSDataTask task) {
    this.rssUrl = rssUrl;
    this.icon = icon;
    this.task = task;
    this.rssItems = rssItems;
}