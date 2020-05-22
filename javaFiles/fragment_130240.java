import java.util.ArrayList;
import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {

    Scanner a = new Scanner(System.in);
    String ans;
    ArrayList<String> itemCodeList = new ArrayList<String>();  //create array list      

    do{

       System.out.print("Item code:");
       itemCodeList.add(a.next());  //add item code into array list

       System.out.print("\nAnother item? [y/n]:");
       ans = a.next();

    }while(ans.equals("y"));

    for (String code : itemCodeList) 
    {
        System.out.println(code);           
    }
   }
 }