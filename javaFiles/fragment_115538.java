// Modify the main class
  package city;

  import castle.Guard;
  import castle.IPrincess;

  public class Main {

  public static void main(String[] args) {

     IPrincess princess = Guard.getPrincessStatic();

     Guard.getPrincessStatic().sayHi();

     Guard guard = new Guard();
     guard.getPrincess().sayHi();

     guard.getPrincessMember().sayHi();
   }
}