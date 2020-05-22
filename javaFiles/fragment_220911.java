ByteArrayOutputStream bos = new ByteArrayOutputStream();
byte[] buf = new byte[1024];
for(int readNum; (readNum=fis.read(buf))!=-1;)
     bos.write(buf,0,readNum);
fis.close();                  // This was the missing code which corrected my issue.
return bos.toByteArray();