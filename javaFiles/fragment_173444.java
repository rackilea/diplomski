class Singleton {
       private static Singleton _instance = new Singleton();
       private Singleton(){}
       public static Singleton getInstance(){
          return _instance;
    }
}