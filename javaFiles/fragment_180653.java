StringBuffer properties = new StringBuffer();
for ( String property : properties_to_pass ) {
    String value = System.getProperty(property);
    if ( value != null ) {
        String r = String.format("-D%s=%s ", property, value);
        properties.append( r );
    }
}