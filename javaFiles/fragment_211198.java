rule "Hello World"
    when
        $email: Email(message.status ==  Message.HELLO, $myMessage: message.message )

    then
        System.out.println( $myMessage );
        m.setMessage( "Goodbye cruel world" );
        m.setStatus( Message.GOODBYE );
        update( m );
end