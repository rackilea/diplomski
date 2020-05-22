public abstact class ParentClass(){

   public void start() {
      System.out.println("Start");
      OtherExample.start();         
      callMethodLetter();
      OtherExample.end();
      System.out.println("End");
   }

   public abstract void callMethodLetter();       

}