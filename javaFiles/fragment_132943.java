public class Tutorials {

   public static void main(String[] args) {
       String[] test = {"go", "stop", "slow"};
       String result = test [new Random().nextInt(test.length)];
       System.out.println(result);

       if (result.equals("stop")) { 
         System.out.println("wait 3 seconds");
       }   
    }
  }