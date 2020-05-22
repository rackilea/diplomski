import java.io.PrintStream;

import oscP5.*;
import netP5.*;

OscP5 oscP5tcpServer;
OscP5 oscP5tcpClient;
NetAddress myServerAddress;

void setup() {
  // overwrite standard System.out
  System.setOut(new PrintStream(System.out) {
    public void println(String s) {
      if(s.indexOf("new Client") != -1){
        clientConnected(getMemoryAddress(s));
      }
      super.println(s);
    }
    // override some other methods?
  });

  oscP5tcpServer = new OscP5(this, 11000, OscP5.TCP);
  oscP5tcpClient = new OscP5(this, "127.0.0.1", 11000, OscP5.TCP);
}

void clientConnected(int memoryAddress){
  println("Client connected, with memory address " + memoryAddress);
}

int getMemoryAddress(String s){
  return Integer.parseInt(s.substring(s.lastIndexOf('@')+1), 16);
}

void draw() {  
}

void mousePressed() {
  oscP5tcpClient.send("/test", new Object[] {new Integer(1)});
}

void keyPressed() {
  println(oscP5tcpServer.tcpServer().getClients().length);
}

void oscEvent(OscMessage theMessage) {
  System.out.println("### got a message " + theMessage);
  if(theMessage.checkAddrPattern("/test")) {
    OscMessage m = new OscMessage("/response");
    m.add("server response: got it");
    oscP5tcpServer.send(m,theMessage.tcpConnection());
  }
}