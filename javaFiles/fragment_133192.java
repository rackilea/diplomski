public class LoginVerification {

public static int check(String username, String pin) {
    boolean usernameFound = false, pinMatches = false;
    try {
        Scanner fileReader = new Scanner(new FileReader("accounts.txt"));

        while (fileReader.hasNextLine() && !usernameFound) {
            usernameFound = fileReader.nextLine().indexOf(username) >= 0; // want username to be passed from other class
        }
        pinMatches = fileReader.nextLine().indexOf(pin) >= 0; // want pin to be passed from other class

        if (usernameFound && pinMatches) {
            return 1; // return 1 to other class
        }

        else {
            return 0; // return 0 to other class
        }
    }

    catch (FileNotFoundException z) {
        JOptionPane.showMessageDialog(null, "No Accounts found. Please register a new account.");
        return 0;
    }

    }
}