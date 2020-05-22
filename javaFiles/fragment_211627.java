import java.io.File;
import java.util.Scanner;

public class readUsers {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("users.txt"));
            reader.useDelimiter("\t|\n");

            String username = "username";
            String password = "password";

            for (int i = 0; i < username.length(); i++) {
                //replace possible unwanted characters
                if (username.charAt(i) < 33 || username.charAt(i) > 126)
                    username = username.replace(Character.toString(username.charAt(i)), "");
            }

            for (int j = 0; j < password.length(); j++) {
                //replace possible unwanted characters
                if (password.charAt(j) < 33 || password.charAt(j) > 126)
                    password = password.replace(Character.toString(password.charAt(j)), "");
            }

            while (reader.hasNextLine()) {
                String user = reader.next();
                String pass = reader.next();

                //if username equals the user in the textfile, check if password equals the pass in the file
                 if (user.equals(username)) {
                    System.out.println("username passed!");
                    if (pass.equals(password))
                        System.out.println("password passed!");
                }   
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}