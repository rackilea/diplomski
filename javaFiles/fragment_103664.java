public class Math {

    public static void main(String args []){
        System.out.println("JDK MATH RANDOM " +java.lang.Math.random()); // refers to java.lang
        System.out.println("My Math random implementation "+Math.random()); // refers to this class method, actually Math is redundant in this scope
    }

   public static double random(){
     //some implementation
   }

}