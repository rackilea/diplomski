public static String[] arystrChunkData(String strData) {
            int intChunks = (strData.length() / CHUNK_THRESHOLD_BYTESIZE) + 1;
            String[] arystrChunks = new String[intChunks];
            int intLength = strData.length(), intPos = 0;

            for( int c=0; c<arystrChunks.length; c++ ) {            
                if ( intPos < intLength ) {
    //Extract a chunk from the data         
                    int intEnd = Math.min(intLength, intPos + CHUNK_THRESHOLD_BYTESIZE);
                    arystrChunks[c] = strData.substring(intPos, intEnd);
                    intPos = intEnd;
                }
            }       
            return arystrChunks;
        }