BufferedInputStream bis = new BufferedInputStream(fis);
ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
byte[] data=new byte[1024];
while((k=audioInputStream.read(data, 0, data.length))>-1) {
  for(int i=0; i<k; i++) data[i]=(byte)(0.5*data[i]);
  outputStream.write(data, 0, k);
}   
byte[] audioData=outputStream.toByteArray();
InputStream bis2=new ByteArrayInputStream(outData);    
player2.play(bis2);