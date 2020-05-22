System.out.println( messageIn );
        } ).start();
        Thread.sleep( 100 ); // allow time for object listening to start

        // write second object to stream

        message = new Message( 2 );
        System.out.println( "writing second object to object output stream: " + message );
        objectOutput.writeObject( message ); // this call seems to block??
        System.out.println( "second object written to object output stream" );
        objectOutput.flush();
        System.out.println( "object output stream flushed" );
    }