int read = 0;
int block = 8192;
int count = 0;
byte[] bytes = new byte[block];
while (read != forSend.length()) {
    count = fin.read(bytes, 0, block);
    out.writeInt(count);
    out.write(bytes, 0, count);
    read += count;
    System.out.println("already sent " + read + " bytes of " + forSend.length());
}