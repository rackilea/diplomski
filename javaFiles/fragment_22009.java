public class Abc {

   public static void main(String[] args) {

       System.out.println(headsOrTails());
   }

   public static boolean headsOrTails() {

       boolean coinState;
       if (Math.random() < 0.5) {//heads 50% of the time 
          coinState = true; //heads
       } else {    
          coinState = false; //tails
       }
       return coinState;
   }

}