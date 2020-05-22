InputStream inputStream = socket.getInputStream();  

// read from the stream  
ByteArrayOutputStream baos = new ByteArrayOutputStream();  
byte[] content = new byte[ 2048 ];  
int bytesRead = -1;  
while( ( bytesRead = inputStream.read( content ) ) != -1 ) {  
    baos.write( content, 0, bytesRead );  
} // while  

// now, as you have baos in hand, I don't think you still need a bais instance  
// but, to make it complete,
// now you can generate byte array input stream as below    
ByteArrayInputStream bais = new ByteArrayInputStream( baos.toByteArray() );