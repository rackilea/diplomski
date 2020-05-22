char[] buff = new char[ 4096 ];
int offset = 0;
while( -1 != br.read( buff, offset, 4096 ) ){
  pw.write( buff );
  offset += 4096;
}