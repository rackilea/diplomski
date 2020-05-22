public class FlipperThree {

     public static void main(String[] args) { 
         System.out.println("Welcome to Flipper!");
         int h = 0;
         int hcount = 0;
         int tcount = 0;
         int ocount = 0;
         String[] ht = new String[] {"Heads","Tails"};
         Random r =new Random();

         while (hcount < 3 && tcount < 3) {
             String random = ht[r.nextInt(ht.length)];
             System.out.println(random);
             if(random.equals(ht[h])){
                 hcount++;
                 ocount++;
                 tcount = 0;
             }
             else{
                 hcount = 0;
                 tcount++;
                 ocount++;
             }
         }
         System.out.println("BINGO!That only took " + ocount+" flips to get 3 in a row!");
     }
 }

$ java FlipperThree
Welcome to Flipper!
Tails
Heads
Heads
Tails
Heads
Heads
Tails
Tails
Tails
BINGO!That only took 9 flips to get 3 in a row!