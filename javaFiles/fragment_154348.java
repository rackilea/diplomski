public class VariableStrings {

   private String[] splitPath;

   public VariableStrings(String unparsedPath) {
     splitPath = unparsedPath.split("/");
   }
}