FileOutputStream fos = new FileOutputStream("file.txt", true); //true means openning file in append mode

byte[] buffer = new byte[1024];
int nread = -1;
while((nread != in.read(buffer, 0, 1024))
    fos.write(buffer, 0, nread);

in.close();
fos.close();