Message messageIn = null;
            try {
                System.out.println( "reading on object input stream" );
                messageIn = (Message) objectInput.readObject();
                System.out.println( "read object on object input stream: " + messageIn );
            } catch ( ClassNotFoundException | IOException e ) {
                e.printStackTrace();
            }