// find the start tag
byte[] startTag = new byte[]{'<', 't', 'a', 'g', '>'};
int fnd = 0;
int tmp = 0;
while((tmp = stream.read()) != -1) {
 if(tmp == startTag[fnd]) 
  fnd++;
 else
  fnd=0;
 if(fnd == startTage.size()) break;
}

// get base64 bytes
while(true) {
 int a = stream.read();
 int b = stream.read();
 int c = stream.read();
 int d = stream.read();
 byte o1,o2,o3; // output bytes
 if(a == -1 || a == '<') break;
 //
 ...
 outputStream.write(o1);
 outputStream.write(o2);
 outputStream.write(o3);
}