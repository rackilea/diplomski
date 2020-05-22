public static class Singleton{
   private static Singleton INSTANCE; // not volatile to illustrate the data-race

   public static Singleton getInstance(){
        if(INSTANCE == null){
            synchronized(Singleton.class){
                 INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
   }
}