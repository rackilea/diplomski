char c = in.read();
while ( c != -1 ) {
   if ( c == 0x0C ) {
     // form feed
   } else {
     // handle displayable character
   }

   c = in.read();
}