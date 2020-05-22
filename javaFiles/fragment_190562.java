List<GeocoderResult> results = geocoderResponse.getResults();
for( GeocoderResult geores: results ){
    if( geores.getTypes().contains( "sublocality" ) ){
        System.out.println( "Address: " + geores.getFormattedAddress() );
    }
}