import java.util.*;

public class perfectsquare {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner s= new Scanner(System.in); 
        double number; 

        System.out.println("Enter number >");

        number= s.nextDouble();
        double sqr= Math.sqrt(number);
        //System.out.println(sqr);
        double num=sqr;
        double x;
        x=num%1;
        x=num-Math.floor(num);
        if(x>0){
            System.out.println("False");
        }
        else{
            System.out.println(sqr);
        }
    }
}