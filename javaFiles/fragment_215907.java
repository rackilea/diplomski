public class sample
{

   public int function_name(String NAME)
   { 

     String str = NAME;

     File exportDir = new File(str);
     if (exportDir.exists()) {
         SVNErrorMessage err = SVNErrorMessage.create(SVNErrorCode.IO_ERROR,        "Path ''{0}'' already exists", exportDir);
         throw new SVNException(err);
     }
     exportDir.mkdirs();

     //continue with your coding 

   }

}