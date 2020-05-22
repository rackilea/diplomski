public static Object toObject( Class clazz, String value ) {
    if( Boolean.class == clazz ) return Boolean.parseBoolean( value );
    if( Byte.class == clazz ) return Byte.parseByte( value );
    if( Short.class == clazz ) return Short.parseShort( value );
    if( Integer.class == clazz ) return Integer.parseInt( value );
    if( Long.class == clazz ) return Long.parseLong( value );
    if( Float.class == clazz ) return Float.parseFloat( value );
    if( Double.class == clazz ) return Double.parseDouble( value );
    return value;
}