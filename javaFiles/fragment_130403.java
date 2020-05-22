public class InterfacesExample {

    /**
     * An interface with one method.
     */
    interface Frobber {
        /**
         * Frob the object.
         * @param object the object
         */
        void frob( Object object );
    }

    /**
     * A factory class with one method for creating printing frobber.
     */
    public static class Frobbers {
        /**
         * Returns a Frobber whose {@link Frobber#frob(Object)} method
         * prints its argument
         * @return a printing Frobber
         */
        public static Frobber newPrintingFrobber() {
            // This returns an instance of an anonymous class
            // that implements the Frobber interface.  It has 
            // to provide an implementation of frob(Object),
            // though.
            return new Frobber() {
                @Override
                public void frob( final Object object ) {
                    System.out.println( "Frobbing "+object+"..." );
                }
            };
        }

        /**
         * Returns a Frobber whose {@link Frobber#frob(Object)} method
         * prints the prefix and its argument
         * @param prefix an object
         * @return a prefixing printing Frobber
         */
        public static Frobber newPrefixingPrintingFrobber( final Object prefix ) {
            return new PrefixingPrintingFrobber( prefix );
        }

        /**
         * A private, but not anonymous class.  Instances shouldn't be
         * made with its constructor, but rather through the factory 
         * method {@link Frobbers#newPrefixingPrintingFrobber(Object)}. 
         */
        private static class PrefixingPrintingFrobber implements Frobber {
            final Object prefix;

            public PrefixingPrintingFrobber( Object prefix ) { 
                this.prefix = prefix;
            }

            @Override
            public void frob( final Object object ) {
                System.out.println( "Frobbing "+prefix+":"+object+"..." );
            } 

        }
    }

    /**
     * Create some frobbers with the factory and test them out.
     */
    public static void main( final String[] args ) {
        final Frobber f1 = Frobbers.newPrintingFrobber();
        f1.frob( 42 );

        final Frobber f2 = Frobbers.newPrefixingPrintingFrobber( "boing" );
        f2.frob( 36 );
    }
}