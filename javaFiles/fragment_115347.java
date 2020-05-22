@Override
public Class<?> loadClass( String name, boolean resolve ) {
    if ( "java.lang.System".equals( name ) ) {
        return SystemWithDifferentTime.class;
    }

    return super.loadClass( name, resolve );
}