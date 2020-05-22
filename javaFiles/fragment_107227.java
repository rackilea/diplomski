public class MyFileFilter implements FileFilter {
   public boolean accept(File pathname) {
     if (pathname.isDirectory())
       return false;
     else {
       String temp[] = pathname.getName().split(".");
       if (temp[1].equals("a")) return true;
     }
   }
}