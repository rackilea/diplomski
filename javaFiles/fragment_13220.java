public interface RSSLister<I> {
    List<I> getRSSItemList();
}

class RSSHandler1 extends DefaultHandler implements RSSLister<RssItem1> {
    public List<RssItem1> getRSSItemList(){
        return rssItemList;
    }
}