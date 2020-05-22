// user interface code can go here
    Scanner s = new Scanner(System.in);

    System.out.println("  Login\n1.New user\n2.Old user: ");
    int in = s.nextInt();
    s.nextLine();
    User user = null;  // hold our user object
    boolean inputNotOK = true; // keep looping until this is false
    GetUserInfo getUserInfo = new GetUserInfo();  // our JPanel for getting user sign in information
    if (in == 1) {
        // code to get a new user
    } else if (in == 2) {
        // code to sign in existing user
        while (inputNotOK) {
            String title = "Get User Name and Password";
            int optionType = JOptionPane.OK_CANCEL_OPTION;
            int msgType = JOptionPane.PLAIN_MESSAGE;
            int value = JOptionPane.showConfirmDialog(null, getUserInfo, title, optionType, msgType);
            if (value == JOptionPane.OK_OPTION) {
                // if the user presses "OK" on the dialog
                String name = getUserInfo.getName();
                char[] pass = getUserInfo.getPass();

                // validUser is a method that you have that checks if the user sign in is appropriate
                if (validUser(name, pass)) {
                    user = new User(name, pass);
                    System.out.println("new user: " + user);
                    inputNotOK = false;
                } else {
                    // show an error JOptionPane here to warn the user
                    // that their sign-on information was incorrect
                }
            }
        }
    }
    s.close();

// method that should check to see if user name and password are acceptable
private static boolean validUser(String name, char[] pass) {
    // TODO code to test if username and password are OK
    // TODO: change this to an actual test
    return true;
}