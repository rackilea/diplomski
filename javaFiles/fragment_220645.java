FileInputStream source=new FileInputStream(....somefile);
tarArchiveOutputStream; prepared to w writing

byte[] buff = new byte[1024*10]; //10kb buff
int numBytesRead = -1; //number of bytes read


while(( numBytesRead = source.read(buff)) > 0 ) {
    // while source has bytes, read from source and write
    // the same number of bytes to the tar outputstream
    tarArchiveOutputStream.write(buff, 0, numBytesRead);
   }
}