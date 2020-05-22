public class RssMain {
    public static final String DEFAULT_URL = "http://twitter.com/statuses/user_timeline/27756405.rss";

    public static void main( String[ ] args ) {
        RssItem[ ] items = parseRssData( DEFAULT_URL );
        for( RssItem item : items ) System.out.println( "Title: " + item.title( ) + " | Link: " + item.link( ) );
    }

    public static RssItem[ ] parseRssData( String url ) {
        URL u;
        InputStream in = null;
        RssHandler handler = new RssHandler( );

        try {
            u = new URL( url );
            in = u.openStream( );

            SAXParser parser = SAXParserFactory.newInstance( ).newSAXParser( );
            parser.parse( in, handler );
        } catch( Exception cause ) {
            cause.printStackTrace( );
        }

        return handler.items.toArray( new RssItem[ 0 ] );
    }
}