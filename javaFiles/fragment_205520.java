String[] arystrChunks = arystrChunkData(strResponse);
    for( String strChunk : arystrChunks ) {
            if ( strChunk != null ) {
                    out.write(strChunk.getBytes());
            }                           
    }