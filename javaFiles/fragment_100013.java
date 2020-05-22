public String encodeRedirectFormat( String samlXML ) throws IOException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Deflater deflater = new Deflater( Deflater.DEFAULT_COMPRESSION, true );
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(os, deflater);
        deflaterOutputStream.write( samlXML.getBytes( "UTF-8" ) );
        deflaterOutputStream.close();
        os.close();
        String base64 = Base64.encodeBase64String( os.toByteArray() );
        return URLEncoder.encode( base64, "UTF-8" );
}