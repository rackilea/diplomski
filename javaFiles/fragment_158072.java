class Child extends Super{
   public void myMethod() {
     System.out.println("in child");
   }
 }

 class Super{
   public static void main(String[] args) {
    Super s = new Child(); 
    s.myMethod(); // At this point you might expect myMethod of child to be called if it'll call the Parent's since it is private.
  }
   private void myMethod() {
     System.out.println("in super");
   }
 }