import java.util.Scanner;
public class Calculator{

    public static void main(String[] args){         
       Scanner input = new Scanner(System.in);

       while (true){
         System.out.println("a: addition");
         System.out.println("s: subtraction");
         System.out.println("m: multiplication");
         System.out.println("d: division");
         System.out.println("q: quit");

         String operator = input.next();
         if (operator.equals("q"){
           return;
         }

         double x = input.nextDouble();
         double y = input.nextDouble();

        if(operator.equals("a")){
            double add;
            add=x+y;
            System.out.println(add);
        }
        else if(operator.equals("s")){
            double sub;
            sub=x-y;
            System.out.println(sub);
        }
        else if(operator.equals("m")){
            double mul;
            mul=x*y;
            System.out.println(mul);
        }
        else if(operator.equals("d")){
            double div;
            div=x/y;
            System.out.println(div);
        }

         else{
           System.out.println("enter one of the proposed options");
         }

      }
    }
}