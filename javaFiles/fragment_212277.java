InputStream is=null;
if ( mConnection != null ) {
   is = mConnection.getInputStream();
   if ( is != null ) {
     ret = is.read(buffer);
   }
   else {
      // log error?
   }
} 
else {
   // log error?
}