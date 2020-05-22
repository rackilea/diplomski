public class MySingleton {
      private MySingleton INSTANCE
      private MySingleton() {
      }

      public static MySingleton getInstance() {
       if (INSTANCE == null) {
         syncronized (MySingleton.class) {
           if (INSTANCE == null) {
             INSTANCE = new MySingletonChild(); // here we are creating an object of subclass of MySingleton.
           }
         }
       }
       return INSTANCE;
      }
     // instance methods exposing business operation
    }