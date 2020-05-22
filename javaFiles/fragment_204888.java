public class MyNamingStrategy extends DefaultNamingStrategy {
   ...
   @Override
   public  String tableName(String tableName) {
      return tableName+yearSuffixTable;
   }
   ...
}