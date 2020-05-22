FileInputStream fis = new FileInputStream("in file");
FileOutputStream fos = new FileOutputStream("out");
byte buffer [] = new byte[8192];
while(true){
  int count = fis.read(buffer);
  if(count == -1)
     break;
  byte[] processed = processBytesToConvert(buffer, count);
  fos.write(processed);
}
fis.close();
fos.close();