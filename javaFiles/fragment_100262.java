<T> JAXBElement<T> wrap( String ns, String tag, T o ){
    QName qtag = new QName( ns, tag );
    Class<?> clazz = o.getClass();
    @SuppressWarnings( "unchecked" )
    JAXBElement<T> jbe = new JAXBElement( qtag, clazz, o );
    return jbe;
}