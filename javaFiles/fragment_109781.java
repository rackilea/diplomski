// readBuffer.flip();                      // <-- remove this line
int i=ClientNIO.client.read(readBuffer); 
if(i>0) { 
    readBuffer.flip();                     // <-- move it here
    byte[] b=readBuffer.array(); 
    System.out.println("Receiving data: "+new String(b)); 
    ...
}