Value v = Value.create();
v.setFirstChild( "x", 5 );
CommMessage request = CommMessage.createRequest( "yourOperationName", "/", v );
LocalCommChannel c = interpreter.commCore().getLocalCommChannel();
try {
    c.send( request );
    CommMessage response = c.recvResponseFor( request ).get();
    if ( response.isFault() ) {
        throw response.fault();
    }
    return response.value();
} catch( ExecutionException | InterruptedException | IOException e ) {
    throw new FaultException( Constants.IO_EXCEPTION_FAULT_NAME, e );
}