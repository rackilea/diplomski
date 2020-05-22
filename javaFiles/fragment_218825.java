public static void displayLogin() {
    System.out.println("\n****** Login Menu ******");
    Scanner loginInput = new Scanner(System.in);
    System.out.print("Enter Username: ");
    String userName = loginInput.next();
    System.out.print("Enter Password: ");
    String password = loginInput.next();
    if (userName.equals("admin") && password.equals("admin123")) {
        displayMainMenu();
    } else {
        System.out.println("\n#Incorrect Username or Password, Please Try Again#");
        displayLogin();
    }
    loginInput.close();
}