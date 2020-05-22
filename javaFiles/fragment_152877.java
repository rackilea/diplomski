public class MyClassLoader extends URLClassLoader {

   protected String findLibrary(String libName) {
         if ( libName.equals("mylib.dll")) {
              return "full/path/to/library";
         }
         else {
              super.findLibrary(libName);
         }
   }
}