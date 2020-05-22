try {
  FileInputStream in = new FileInputStream("xanadu.txt");
  FileOutputStream out = new FileOutputStream("outagain.txt");
  int c;
  ....
} catch(Exception e) {

} finally {
   try {
     if(in != null) { //in could not be resolved error by compiler       
       in.close();
     }
     if(out != null) { //out could not be resolved...
       out.close();
     }
   catch(Exception e) {...}
}