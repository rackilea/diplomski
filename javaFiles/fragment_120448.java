Class clazz = Yourclass.class;

while ( clazz != null ) {
    Field f = null;
        try {
            f = clazz.getDeclaredField( "logger" );
        } catch ( NoSuchFieldException e ) {
            clazz = clazz.getSuperclass();
        }
    if ( f != null ) {
        f.setAccessible( true );

        //here we must hack final modifier for field
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);

        //here pass your object which should contain logger field
        f.set( yourObject,  mock(mockSomeClass) );
        break;
    }
}