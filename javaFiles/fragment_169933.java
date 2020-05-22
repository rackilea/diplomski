String stuff="Z:\\123456_tre\\12345.mpg;0;2343;3423;43234";
  getFilename(stuff); // will get the filename

  public String  getFilename(String fullFilename) {
       String filename=fullFilename.substring(fullFilename.lastIndexOf("\\")+1); // this will get  12345.mpg;0;2343;3423;43234
       return filename.substring(0,filename.indexOf(";"));
   }