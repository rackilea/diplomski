String  messageStr="Hello Android!";
int server_port = 12345;
DatagramSocket  s = new DatagramSocket ();
InetAddress  local = InetAddress .getByName("192.168.1.102");
int msg_length=messageStr.length();
byte[] message = messageStr.getBytes();
DatagramPacket  p = new DatagramPacket (message, msg_length,local,server_port);
s.send(p);