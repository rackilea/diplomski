import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username, password;
        System.out.print("Enter Username: ");
        username = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();

        if (authenticated(username, password)) {
            System.out.println("Passenger login successful!");
        } else {
            System.out.println("Please check your username or password and try again!");
        }
    }

    static boolean authenticated(String username, String password) {
        BufferedReader saveUsrFile, savePwFile;
        boolean usrFound = false, pwFound = false;
        try {
            saveUsrFile = new BufferedReader(new FileReader("username.txt"));
            String line_u = saveUsrFile.readLine();
            while (line_u != null) {
                if (line_u.equals(username)) {
                    usrFound = true;
                    break;
                }
                line_u = saveUsrFile.readLine();
            }
            saveUsrFile.close();

            savePwFile = new BufferedReader(new FileReader("password.txt"));
            String line_p = savePwFile.readLine();
            while (line_p != null) {
                if (line_p.equals(password)) {
                    pwFound = true;
                    break;
                }
                line_p = savePwFile.readLine();
            }
            savePwFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usrFound && pwFound;
    }
}