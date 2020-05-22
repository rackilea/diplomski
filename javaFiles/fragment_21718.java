//*******************************************************************
// Welcome to CompileJava!
// If you experience any issues, please contact us ('More Info')  -->
//*******************************************************************

import java.lang.Math; // headers MUST be above the first class
import java.util.HashMap;

// one class needs to have a main() method
public class HelloWorld
{
  public static int[] array = {1,2,3,4,5,6,7,8,9,10};
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {

    System.out.println(getTotal());
  }


  private static HashMap<Integer,Integer> getTotal(){
    int total = 0;
    HashMap<Integer,Integer> finalTotal = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
        total += array[i];
        System.out.println("");
        System.out.println("//i = " + i + "; arr[i] = " + array[i]);
        System.out.println("total += " + array[i] + "; // total = " + total);
        for (int j = i+1; j < array.length; j++) {
            System.out.println("    //j = " + j + "; arr[j] = " + array[j]);
            if(total>5){
                finalTotal.put(j,total - array[j]);
                System.out.println("    finalTotal += (" + j+", "+total + "-" + array[j]+")");
                total = 0;
            }
            else if(total<5){
                total += array[j];
                System.out.println("    total += " + array[j]+"; //total = "+total);
            }
        }
    }
    return finalTotal;
  }
}