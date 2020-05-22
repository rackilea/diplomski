InputStream ins = getResources().openRawResource(R.raw.my_db_file);
ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
int size = 0;
// Read the entire resource into a local byte buffer.
byte[] buffer = new byte[1024];
while((size=ins.read(buffer,0,1024))>=0){
  outputStream.write(buffer,0,size);
}
ins.close();
buffer=outputStream.toByteArray();