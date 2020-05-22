import java.util.Scanner;

public class PromptPassword {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Password rules:\n"
                            + "Password must have at least eight characters\n"
                            + "Password must consist of only letters and digits\n"
                            + "Password must contain at least two digits\n"
                            + "Enter a password:");
        String pWT = sc.nextLine(); //read the entire line
        passWordIsValid(pWT.trim()); // to remove leading spaces (if any)
    }   
    public static void passWordIsValid (String password) {
        boolean passWordIsValid = true;
        int noOfDigits =0;


        if (password.length() > 8) { // if it's less than 8 chars -> no need to continue
            for(char c : password.toCharArray()){
                if(Character.isDigit(c)){ // if it's a digit, increment
                    noOfDigits++;
                }
                else if(!Character.isAlphabetic(c)){ // if it's not a digit nor alphapet
                    passWordIsValid = false;
                    break;
                }
            }
        }

         if (passWordIsValid && noOfDigits>=2){
             System.out.print("Password is valid");
         }
         else{
             System.out.println("Password is invalid"); 
         }

    }
}