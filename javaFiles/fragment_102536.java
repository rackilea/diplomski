String message;
String senderName;

announcer( member x , String msg ) {
    senderName = x.name;
    message= x.name + " : " + msg ;
}

public void run() {
    for ( int i=0 ; i<server.group.size() ; i++ ) {
        if ( !server.group.get( i ).name.equals( senderName ) ) {
            send( server.group.get( i ).sck );
        }
    }
}