Message message = new Message.Builder()
    .sender( new User( ... ) )
    .recipient( new User( ... ) )
    .subject( "Hello, world!" )
    .text( messageText )
    .build();