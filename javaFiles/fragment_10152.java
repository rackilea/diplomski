DataInputStream dis = new DataInputStream(socket stream);
byte[] bytes = new byte[5];

int sep;
do {
  dis.readFully(bytes);
  process(bytes);
} while((sep = dis.read()) == '=');
if (sep > 0)
   System.err.println("Unexpected character "+ (char) sep));