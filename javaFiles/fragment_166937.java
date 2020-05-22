public static HashMap< String, Field > getFields2( Class<?> klass ) {
    HashMap< String, Field > fields = new HashMap< String, Field >();
    for ( Field f : klass.getFields() ) {
        fields.put( f.getName(), f );
    }
    return fields;
}