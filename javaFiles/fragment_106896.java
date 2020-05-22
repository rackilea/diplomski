if( fileName.lastIndexOf("\\") >= 0 ){
  file = new File( filePath + 
  fileName.substring( fileName.lastIndexOf("\\"))) ;
}else{
  file = new File( filePath + 
  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
}

// rename if file exists
int i = 1;
while (file.exists()) { // keep renaming as file_(2) , file_(3) etc.
    String path = file.getAbsolutePath();
    int iDot = path.lastIndexOf(".");
    file = new File(path.substring(0, iDot) +
           "_(" + ++i + ")" + path.substring(iDot));
}

fi.write( file ) ;