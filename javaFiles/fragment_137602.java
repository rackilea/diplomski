import java.util.*;
import java.io.*;

public class Serials {


public static void main(String[] args) {        
    int T = 0; //First Integer to be inputed 
    //tells me how many sub ArrayLists I will have

    List<List<Integer>> parentList =new ArrayList();  //parentList
    List<Integer> subList = new ArrayList();          //subList

    Scanner q=new Scanner(System.in);
    System.out.println("How many substrings do we need");
    T = Integer.parseInt(q.nextLine()); //Scanning in T Value

    for(int i=0; i<T; i++) {
    String x = q.nextLine();
    String[] arr= x.split(" ");
    subList = new ArrayList<Integer>();
    for(int j=0;j<arr.length;j++)
    {

    subList.add(Integer.parseInt(arr[j]));

    }
    parentList.add(i, subList);  
    }


    System.out.println( "SubString 0 contains" + parentList.get(0));
    System.out.println( "SubString 1 contains" + parentList.get(1));
    }
}