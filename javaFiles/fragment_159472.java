import java.util.Scanner;

Scanner scan = new Scanner(System.in);       
int input, result;

System.out.print("Enter an integer number: ");
input = Integer.valueOf(scan.nextLine());//Needed to make the scan of the
//produce a integer rather than a string.

result = input%2; 

if (result == 0) {
    System.out.println("\n\n Number " + input + " is even.");
}
else if (result != 0) {
    System.out.println("\n\n Number " + input + " is odd.");
}
}    
}