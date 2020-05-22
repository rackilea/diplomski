RandomAccessFile f = new RandomAccessFile(fileName, "rw");
long length = f.length() - 1;
do {                     
  length -= 1;
  f.seek(length);
  byte b = f.readByte();
} while(b != 10);
f.setLength(length+1);
f.close();