import java.util.Collections;
import java.util.Scanner;

public class ArrayYear {

    public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    int[] arr = new int[3];
    int[] year = new int[3];

    // read element into array
    for (int i = 0 ; i < arr.length; i++)
    {
     // input value
     arr[i] = in.nextInt(); 
     year[i] = in.nextInt();

      // reverse array year[i] in descending order
     for (int j = 0 ; j < year.length ; j++)
      {
        if ( year[i] < year[j] )
        {
        int temp = year[i];
        year[i] = year[j];
        year[j] = temp;
        }
      }                 
    }

      for (int i = arr.length-1 ; i >= 0 ; i--)
      {
      // print array
       System.out.println("ID :" + arr[i] + "(" + year[i] + ")");   
      }
   }
}
      //my output :      
      ID :3(2001)
      ID :2(2000)
      ID :1(1988)

      //sample output:
      ID: 2 (2001)
      ID: 3 (2000)
      ID: 1 (1998)