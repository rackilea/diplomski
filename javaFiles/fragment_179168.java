// write first object to stream

        Message message = new Message( 1 );
        System.out.println( "writing first object to object output stream: " + message );
        objectOutput.writeObject( message );
        System.out.println( "first object written to object output stream" );
        objectOutput.flush();
        System.out.println( "object output stream flushed" );

        // start reading in a separate thread

        new Thread( () -> {
            ObjectInput objectInput = null;
            try {
                objectInput = new ObjectInputStream( socket.getInputStream() );
            } catch ( IOException e ) {
                e.printStackTrace();
            }