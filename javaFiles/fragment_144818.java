B b = new B() {
   @Override
   public void doProcess(){
      System.out.println("Process from Anonymous class");
   }        
}
System.out.println (b.getClass ().getSuperclass ());