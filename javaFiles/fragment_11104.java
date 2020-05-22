public void parseStream( InputStream is ) throws IOException 
    {
        boolean vtoggle = true; // Are we converting to long or double?
        ByteBuffer idBuffer = ByteBuffer.allocate( 4 ); // Initialize our id buffer
        ByteBuffer valueBuffer = ByteBuffer.allocate( 8 ); // Initialize our value buffer

        while( true /*or some real condition*/ )
        {
            idBuffer.put( readFromInput( is, 4 ) ); // Store the id bytes
            valueBuffer.put( readFromInput( is, 8 ) ); // Store the value bytes
            int id = idBuffer.getInt(); // Convert id bytes
            if( vtoggle )
            {
                long lvalue = valueBuffer.getLong(); // Convert long bytes
                // Do something with value
            }
            else
            {
                double dvalue = valueBuffer.getDouble(); // Convert double bytes
                // Do something with value
            }
            idBuffer.clear(); // Reset id buffer
            valueBuffer.clear(); // Reset value buffer
            vtoggle = !vtoggle; // Code to alternate whether or not we are converting to long or double
        }
    }

    /**
     * Read and return a certain number of bytes from our stream
     */
    public byte[] readFromInput( InputStream is, int count ) throws IOException
    {
        byte[] buffer = new byte[ count ];
        int bytesRead = 0;
        int offset = 0;
        while( ( bytesRead = is.read( buffer, offset, buffer.length - offset  ) ) > 0 )
        {
            offset += bytesRead;
        }
        if( offset == buffer.length )
        {
            return buffer;
        }
        else
        {
            throw new IOException( "Unexpected end to stream." );
        }
    }