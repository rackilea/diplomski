Poller poller      = new Poller(1);                  // new INSTANCE
poller.register( socket, Poller.POLLIN );            // pay COSTS of SETUP
                                                     //     JUST ONCE, HERE
while ( !Thread.currentThread ().isInterrupted () ) {// inf LOOP

    poller.poll();                                   //     POLL !BLOCKING
    if ( poller.pollin( 0 ) ) {                      //     if ITEMS{ ... proc 'em }
    ZMsg zmqMessage  = ZMsg.recvMsg( socket );
    if ( zmqMessage != null )
         zmqMessage.getFirst().getData();
    }
}