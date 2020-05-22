OutputStream gout= new GZIPOutputStream( System.out );
System.setOut( new PrintStream( gout ));              //<<<<< EDIT here
while(( bytesRead = bf.read( buff )) != -1 ) {
   gout.write(buff,0,bytesRead);
}
gout.close(); // close flush the last remaining bytes in the buffer stream