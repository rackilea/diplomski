<T> JAXBElement<T> wrap( String ns, String tag, T o ){
    QName qtag = new QName( ns, tag );
    Class<?> clazz = o.getClass();
    @SuppressWarnings( "unchecked" )
    JAXBElement<T> jbe = new JAXBElement( qtag, clazz, o );
    return jbe;
}

void marshal() throws Exception {
    Foo foo = new Foo();
    //...
    JAXBElement<Foo> jbe = wrap( "", "Foo", foo );
    JAXBContext jc = JAXBContext.newInstance( PACKAGE );
    Marshaller m = jc.createMarshaller();
    m.marshal( jbe, ... );
}