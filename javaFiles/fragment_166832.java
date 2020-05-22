import java.util.Scanner;

//Note, class name must start from capital letter
//See code conventions: https://howtodoinjava.com/java/basics/java-naming-conventions/
public class Siblings {

public static void main (String [] argrs){
    String [] family =  { "Potter", "Weasley", "Grangley", "Dubmbledore", "Black", "Patil", "Creevey"};
    String [] [] siblings = {
            {"harry"},
            {"bill", "charlie", "percry", "fred", "george", "ron", "ginny"},
            {"hermione"},
            {"Ablus","aberforth", "arrianna"},
            {"Sirius", "regulus"},
            {"padma", "pavarti"},
            {"colin", "dennnis"}};


    Scanner kb = new Scanner (System.in);
    System.out.println("Enter a family name selecting one of those: ");
    System.out.println("");
    for(String name: family){
        System.out.print(name);
        System.out.print(" ");
    }

    String input = kb.next();//note I did not convert to lower case here


    int i = 0;
    String mySiblings[]  = null;
    for(String member: family){
        if(input.equalsIgnoreCase(member)){//note how I ignore the case,, when checking
            mySiblings = siblings[i];
            break;
        }
        i++;
    }

    System.out.println("Siblings of "+input + " are:");

    for(String sibling: mySiblings){
        System.out.print(sibling);
        System.out.print(" ");
    }

    //Continue your code here

}