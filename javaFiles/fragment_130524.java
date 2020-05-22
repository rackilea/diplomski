String  text;
int server_port = 12345;
byte[] message = new byte[1500];
DatagramPacket  p = new DatagramPacket (message, message.length);
DatagramSocket  s = new DatagramSocket (server_port);
s.receive(p);
text = new String (message, 0, p.getLength());
Log.d("Udp tutorial","message:" + text);
s.close();