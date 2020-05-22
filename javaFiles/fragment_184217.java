public static void main( String[] args ) throws Exception {
    String str = "<a path=\"A\"><b path=\"B\"><c filename=\"C\">1</c><c filename=\"D\">2</c><c filename=\"E\">3</c></b></a>";
    Map<String, String> map = new HashMap<>();
    Deque<String> stack = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    DefaultHandler sax = new DefaultHandler() {

        @Override
        public void startElement( String uri, String localName, String qName, Attributes attributes ) throws SAXException {
            String path = "?";
            for ( int index = 0 ; index < attributes.getLength() ; index += 1 ) {
                String localnameAttr = attributes.getLocalName( index );
                if ( localnameAttr.equals( "path" ) || localnameAttr.equals( "filename" ) ) {
                    path = attributes.getValue( index );
                    break;
                }
            }
            stack.offerLast( path );
        }

        @Override
        public void endElement( String uri, String localName, String qName ) throws SAXException {
            StringBuilder path = new StringBuilder();
            for ( String s : stack ) {
                path.append( s ).append( '/' );
            }
            if ( path.length() > 0 ) {
                path.setLength( path.length() - 1 );
                map.put( sb.toString(), path.toString() );
            }
            sb.setLength( 0 );
            stack.removeLast();
        }

        @Override
        public void characters( char[] ch, int start, int length ) throws SAXException {
            sb.append( ch, start, length );
        }

    };
    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxPareser = spf.newSAXParser();
    saxPareser.parse( new ByteArrayInputStream( str.getBytes() ), sax );

    System.out.println( "1 => " + map.get( "1" ) );
    System.out.println( "2 => " + map.get( "2" ) );
    System.out.println( "3 => " + map.get( "3" ) );

}