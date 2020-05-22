import java.util.Scanner;

public class Lock {
    public static void main(String [] args){

        String user_name = question();
        String pass_word = ask();

        int count = 0;

        while (count < 4) {
            int result = testing(user_name, pass_word);

            if (result == 0) {
                System.out.println("Welcome");
            }
            count++;
        }

        if (count > 3) {
            System.out.println("Locked");
        }

    } //end of main 

    //2. method for asking username
    public static String question(){
        Scanner input = new Scanner (System.in);

        System.out.println("Enter username: ");
        String username = input.nextLine();

        input.close();

        return username;
    }

    //3. method for asking password
    public static String ask(){
        Scanner input = new Scanner (System.in);

        System.out.println("Enter Password: ");
        String password = input.nextLine();

        input.close();

        return password;

    }


    //4. method for testing whether username and password are true
    public static int testing(String inputname, String inputpw){
        int result = 0;
        String username = "edu";
        String password = "12345";

        if (!(username.equals(inputname)) || ! (password.equals(inputpw)))
            result = 1;

        return result; //return statment

    }
}