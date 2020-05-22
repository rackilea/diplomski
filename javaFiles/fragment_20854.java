Socket socket;
public Client(Socket socket){
    this.socket = socket;
}
public void run(){
    while(socket.isConnected()){
        //here reads the packets from the inputstream
    }
}