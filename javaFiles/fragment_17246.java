public class NumbersFunctions {

 public static void main(String[] args) {
   Scanner keyboard = new Scanner(System.in);

   double x, y, z;
   System.out.println("Please input 3 numbers");
   x = keyboard.nextDouble();
   y = keyboard.nextDouble();
   z = keyboard.nextDouble();

   smallest(x, y, z);

}  

public static void smallest(double x, double y, double z)
{

   if(x < y && x < z){
     System.out.println(x);
   }else if(y < z){
     System.out.println(y);
   }
 }
}