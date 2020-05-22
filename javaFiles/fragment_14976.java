MyClient m; //for access to the GUI pieces

MyCommandReciever(DataInputStream commandIn, MyClient m){
    this.commandIn = commandIn;
    this.m = m;
}