import org.apache.commons.io.FileUtils;
// the rest import
public class MyClass{
  public myMethod(){
   String src = "/home/user/dir_src";
   String dst = "/home/user/dir_dst";
   try{
      FileUtils.copyDirectory(new File(src), new File(dst)); 
   catch(IOException e){
      e.printStackTrac();
   }
  }
}