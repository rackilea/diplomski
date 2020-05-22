public String myServiceMethod (String myPathParameter) {
       String encodedUTF8 = null;
       try{
           byte[] utf8 = myPathParameter.getBytes("ISO-8859-1");        
           encodedUTF8 = new String(utf8, "UTF8");
           return encodedUTF8;
       }
       catch(java.io.UnsupportedEncodingException e){
         // logger that states that the encoding went wrong
       }
}