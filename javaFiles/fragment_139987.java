public class Glob_variable 
{
     private Glob_variable GVariableClass;
     private static String Path;
     private Glob_variable()
     {
          GVariableClass = this;
     }

     public static Glob_variable getInstance()
     {
           if ( GVariableClass == null )
           {
                 GVariableClass = new Glob_variable();
           }
           return GVariableClass;
     }

        /**********************************************/
        public void setPath(String Path) {
            this.Path = Path;
        }

        public String getPath() {
            return Path;
        }
        /**********************************************/

    }