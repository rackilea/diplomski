int block = 8192;
int count = 0;
int read = 0;
byte[] bytes = new byte[block];
System.out.println("recieving file...");
while (read != length) {
    block=in.readInt();
    in.readFully(bytes, 0, block);
    fout.write(bytes, 0, block);
    read += block;
    System.out.println("already recieved " + read + " bytes of " + length);
}