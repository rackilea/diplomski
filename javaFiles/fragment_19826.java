InputStream is = socket.getInputStream();
ByteArrayOutputStream stream = new ByteArrayOutputStream();
byte[] buf = new byte[4096];
int len;
while((len=is.read(buf))>-1){
    stream.write(buf,0,len);
}
stream.flush();