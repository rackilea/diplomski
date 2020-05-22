public class SomeDaoImpl implements SomeDaoInterface {

   public void someDaoMethod() throws Exception { 
      // code ...

      try {
         // code
      } catch(EmptyResultDataAccessException dataAccessException) {
         // rethrow exception
         throw new Exception(dataAccessException.toString()); // you can rethrow RuntimeException or Custom exceptions
      }
   }
}