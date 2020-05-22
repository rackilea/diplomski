import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

Scanner in = new Scanner(System.in);
List<String> operationHistory=new ArrayList<String>();
Integer userInput = null;
do{
    System.out.println("Please select operation");
    System.out.println("1. aaa");
    System.out.println("2. bbb");
    System.out.println("3. print selection history");
    System.out.println("4. exit");
    userInput = Integer.valueOf(in.nextLine());

    if (userInput.equals(1)) {
        System.out.println("Please type something");
        String userInputEncode = in.nextLine().toLowerCase();
        operationHistory.add("1. aaa - " + userInputEncode);
    }else if (userInput.equals(2)) {.
        System.out.println("Please type something");
        String userInputEncode = in.nextLine().toLowerCase();
        operationHistory.add("2. bbb - " + userInputEncode);
    }else if (userInput.equals(3)) {
        System.out.println("Operation History:");
        for(String operationitem:operationHistory){
            System.out.println(operationitem);
        }
        System.out.println("-------------");
    }

}while(!userInput.equals(4));
in.close();
System.out.println("Program was closed by user");