String message;
member sender;

announcer( member x , String msg ) {
    sender = x;
    message= x.name + " : " + msg ;
}

public void run() {
    for ( int i=0 ; i<server.group.size() ; i++ ) {
        if ( server.group.get( i ) != sender ) {
            send( server.group.get( i ).sck );
        }
    }
}