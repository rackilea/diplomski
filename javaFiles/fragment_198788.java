//import java.util.Scanner;//delete this part after 
public class findingRoots {
    public static void main(String[] args) { 
        double temp = printRoots(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }
    public static double printRoots (int a, int b, int c){ //should it be double here or int? 
       //read in the coefficients a,b,and c 
       //now compte the discrimintat d 
       double discriminant = (Math.pow(b, 2.0)) - (4 * a * c);
       double d=Math.sqrt(discriminant);
       double X = 0,Y = 0; //root 1 & root 2, respectively
       // is the step double X,Y necessary? 
       d = (b*b)-(4.0*a*c);

       if (discriminant > 0.0) { 
           X = (-b + d)/(2.0 * a ); //X= root 1, which is larger 
           //do i put int or double in front of X?** 
           Y = (-b - d)/(2.0 *a); //Y= root 2, which is the smaller root 
           String root1 = Double.toString(X);
           String root2 = Double.toString(Y);
           System.out.println("The two roots are X and Y:" + root1 + "and" + root2);
       }
       else if (discriminant==0.0){
           X = (-b + 0.0)/(2.0 * a);//repeated root
           String root2 = Double.toString(X);
           System.out.println("The equation has one root X:"  + root2);//where X is the only root 
       }
       else if (discriminant < 0.0){
           double X1 = -b/(2*a);
           double Y1 = (Math.sqrt(-c))/(2*a);
           double X2 = -b/(2*a);
           double Y2 = (-(Math.sqrt(-c)))/(2*a);
           String root1 = Double.toString(X1);
           String root2 = Double.toString(Y1);
           String root3 = Double.toString(X2);
           String root4 = Double.toString(Y2);
           System.out.println("The equation has two roots:" + root1 + root2  + "and" + root3 + root4);
           // where i represents the square root of negative 1 
      }
      return -1;
    }
}