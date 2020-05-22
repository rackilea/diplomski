socket = new Socket("192.168.1.101", 9100);
out = new DataOutputStream(socket.getOutputStream());
DataInputStream input = new DataInputStream(socket.getInputStream());


final char ESC = 0x1b;
final String UNESCAPED_UEL  = "%-12345X";
String UEL = ESC + UNESCAPED_UEL;
out.writeBytes(UEL); 
out.writeBytes("@PJL\r\n");
out.writeBytes("@PJL SET PAPER = LETTER\r\n");
out.writeBytes("@PJL ENTER LANGUAGE = PDF\r\n");
for(int i=0; i<copies; i++) {
    out.write(ps, 0, ps.length);
}
out.writeBytes(UEL); // <-- add this
out.flush();