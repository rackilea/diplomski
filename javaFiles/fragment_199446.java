/**
* @param <M> message type
*/
class Processor < M > {

    Dispatcher<M> dispatcher;

    public Processor ( Dispatcher<M> dispatcher ) {
        this.dispatcher = dispatcher;
    }

    void run ( M...messages ) {
        for ( M message : messages ) {
            // as there is no mechanism in java to get from Class<T> to Foo<T>, this call
            // must be made with the wildcard H Foo<?>
            dispatcher.dispatch ( message );
        }
    }
}

interface Dispatcher<M> {
    <T extends M> void dispatch ( T message );
}

class Message {
}

class ServerMessage extends Message {
    //...
}

interface ServerMessageHandler<T extends ServerMessage> {
    //...
    void process ( T msg, String param ) ;
}

class ServerDispatcher implements Dispatcher<ServerMessage > {
    HashMap < Class < ? extends ServerMessage >, ServerMessageHandler<?> > handlerMap = new 
    HashMap < Class < ? extends ServerMessage >, ServerMessageHandler<?> > ();

    <T extends ServerMessage >
    void addHandler ( ServerMessageHandler<T> handler, Class < T > clz ) {
        handlerMap.put ( clz, handler );
    }

    @SuppressWarnings("unchecked")
    // cannot use a trick like clz.cast() as we want ServerMessageHandler<T> rather than T
    <T extends ServerMessage> ServerMessageHandler<T> getHandler ( Class < ? extends ServerMessage > clz ) {
        return ( ServerMessageHandler<T> ) handlerMap.get(clz);
    }

    @Override
    public <T extends ServerMessage>
    void dispatch ( T message ) {
        ServerMessageHandler<T> serverMessageHandler = getHandler ( message.getClass() );

        serverMessageHandler.process ( message, "wibble" );
    }
}