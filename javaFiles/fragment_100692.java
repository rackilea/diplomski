public static class Singleton{
   private static volatile Singleton INSTANCE; // volatile to illustrate the race condition

   public static Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
   }
}