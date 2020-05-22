InputStream input = ....;
ByteArrayOutputStream bo = new ByteArrayOutputStream();
while (true){
   int singlebyte = input.read();
   if (singlebyte == -1) break; //stream ends
    bo.write(singlebyte);
    if (singlebyte == '*'){
       //the byte you are wating. at this point, you can break loop. or continue to read
       bo.write(singlebyte);
       byte data[] = bo.toByteArray();
    }
}