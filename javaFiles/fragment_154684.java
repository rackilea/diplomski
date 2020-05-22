FileInputStream in = null;
FileOutputStream out = null;

try {
  in = new FileInputStream("xanadu.txt");
  out = new FileOutputStream("outagain.txt");
  int c;
  ....
} catch(Exception e) {

} finally {
   try {
     if(in != null) {       
       in.close();
     }
     if(out != null) {
       out.close();
     }
   catch(Exception e) {...}
}