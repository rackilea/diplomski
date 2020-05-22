public class SqlController {

   //Put you connection string with pw, user, ... here
   private static final String YOUR_CONNECTION_STRING = ""; 

   public boolean openConnection() {
       boolean result;
       try {
           // Open your connection
           result = true;
       } catch (Exception e) {
        result = false;
       }
       return result;
   }

   public boolean closeConnection() {
       boolean result;
       try {
           // Close your connection
           result = true;
       } catch (Exception e) {
           result = false;
       }
       return result;
   }

   public YourData getSomeData(){

    //get The Data you want.
    return YourData;
   }
}