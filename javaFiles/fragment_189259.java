List<OffsetDateTime> odts = new ArrayList<>();

OffsetDateTime odt = OffsetDateTime.parse( "2016-01-15T00:44:59+08:30" ) ;
odts.add( odt );
… // Parse remaining ISO 8601 strings, adding each new OffsetDateTime object to collection.

Collections.sort( odts );