public saveBLocks( List<Block> blocks ) {
    DataOutputStream stream = new DataOutputStream( new FileOutputStream( "someFile.txt" ) );
    try {
        for( int i = 0; i < blocks.size(); i++ ) {
           byte[] buffer = createBuffer( blocks.get(i) );

           // save out the block size to the stream if we have varying block size
           stream.writeInt( buffer.length );

           // save the block, assumes buffer is the exact size of the block
           stream.write( buffer, 0, buffer.length );
        }
        stream.flush();
    } finally {
        stream.close();
    }
}