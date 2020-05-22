public class Something {
     public static void main(String args[]) {

         Scanner s = new Scanner(System.in);
         char c1,c2;

         c1 = s.findWithinHorizon(".", 0).charAt(0);
         c2=s.findWithinHorizon(".", 0).charAt(0);
         System.out.print(c1);
         System.out.print(c2);

         s.close();
     }   
}