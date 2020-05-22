public class QuickArray< E extends Superclass > {
        private final E[] array;
        private int elementCount;

        @SuppressWarnings( { "unchecked" } )
        public QuickArray( final Class< E > clazz, final SomeField someField, final int size ) {
            array = (E[])Array.newInstance( clazz, size );
            for ( int i = 0; i < array.length; i++ ) {
                try {
                    array[ i ] = clazz.getDeclaredConstructor( SomeField.class ).newInstance( someField );
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }
            elementCount = 0;
        }

        public E get( final int i ) {
            return array[ i ];
        }
        // some other fancy methods
    }