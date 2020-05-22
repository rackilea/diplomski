SecureMessageServer server;

public SecureMessageServerClientThread(SSLSocket socket, SecureMessageServer server){
    this.socket=socket;
    this.server=server;
}