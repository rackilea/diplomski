public interface IAuthDataAccess {

   @Restricted
   void save(Doc doc, User user) throws SecurityException;
   ...
}