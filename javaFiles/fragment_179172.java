Socket socket = socketChannel.socket();
        ObjectOutput objectOutput = new ObjectOutputStream( socket.getOutputStream() );
        ObjectInput objectInput = new ObjectInputStream( socket.getInputStream() );

        // read first object

        System.out.println( "reading first object on object input stream" );
        Message message = (Message) objectInput.readObject();
        System.out.println( "read first object on object input stream: " + message );

        // read second object

        System.out.println( "reading second object on object input stream" );
        message = (Message) objectInput.readObject();
        System.out.println( "read second object on object input stream: " + message );

        // write confirmation message

        message = new Message( 42 );
        System.out.println( "writing confirmation message to object output stream: " + message );
        objectOutput.writeObject( message );
        System.out.println( "confirmation message written to object output stream" );
        objectOutput.flush();
        System.out.println( "object output stream flushed" );
    }