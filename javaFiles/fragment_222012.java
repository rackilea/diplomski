private static Test instance;
public static Test create(){
   synchronized (Test.class) {
      if(instance == null)
         instance = new Test();
   }

   return instance;
}