public class DuplexBase64MarshallAdapter extends XmlAdapter<String, byte[]> {

        /**
         * running the adapter in half duplex mode means, the incoming data is marshaled but the
         * outgoing data not.
         */
        public static final boolean HALF_DUPLEX = false;

        /**
         * Running the adapter in full duplex means, the incoming and outgoing data is marshalled.
         */
        public static final boolean FULL_DUPLEX = true;

        private boolean isFullDuplexMode;

        public DuplexBase64MarshallAdapter() {
            this.isFullDuplexMode = HALF_DUPLEX;
        }

        /**
         * Constructor
         * 
         * @param fullDuplex
         *            use {@link #HALF_DUPLEX} or {@link #FULL_DUPLEX}
         */
        public DuplexBase64MarshallAdapter( boolean fullDuplex ) {
            this.isFullDuplexMode = fullDuplex;
        }

        @Override
        public byte[] unmarshal( String v ) throws Exception {
            return Base64.decode( v );
        }

        /**
         * Return always an empty string. We do not want to deliver binary content here.
         */
        @Override
        public String marshal( byte[] v ) throws Exception {
            if( isFullDuplexMode ) {
                return Base64.encodeBytes( v );
            }
            return "";
        }

    }