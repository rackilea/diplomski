public class RssHandler extends DefaultHandler {
    public final ArrayList< RssItem > items;

    private boolean isItem = false;
    private boolean isTitle = false;
    private boolean isLink = false;

    String value = "";
    RssItem current = null;

    public RssHandler( ) {
        items = new ArrayList< RssItem >( );
    }

    @Override
    public void startElement( String uri, String localName, String name, Attributes attributes ) throws SAXException {
        if( !isItem  && name.equalsIgnoreCase( "item" ) ) isItem = true;
        else {
            if( name.equalsIgnoreCase( "title" ) ) isTitle = true;
            if( name.equalsIgnoreCase( "link" ) ) isLink = true;
        }
    }

    @Override
    public void endElement( String uri, String localName, String name ) {
        if( isItem && name.equalsIgnoreCase( "item" ) ) isItem = false;
        else if( isTitle || isLink ) {
            if( current == null ) current = new RssItem( );

            if( name.equalsIgnoreCase( "title" ) ) {
                isTitle = false;
                current.title( value );
            } else if( name.equalsIgnoreCase( "link" ) ) {
                isLink = false;
                current.link( value );
            }

            value = "";
            if( ( current.title( ) != null ) && ( current.link( ) != null ) ) {
                items.add( current );
                current = null;
            }
        }
    }

    @Override
    public void characters( char[ ] chars, int start, int length ) throws SAXException {
        if( isTitle || isLink ) value = value.concat( new String( chars, start, length ) );
    }
}