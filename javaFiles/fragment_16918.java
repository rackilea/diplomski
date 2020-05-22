public class RssItem {
    private String title;
    private String link;

    public String title( ) {
        return title;
    }

    public RssItem title( String title ) {
        this.title = title;
        return this;
    }

    public String link( ) {
        return link;
    }

    public RssItem link( String link ) {
        this.link = link;
        return this;
    }
}