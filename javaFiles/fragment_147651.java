public static void main(String[] args) {
    System.out.println("Enter a desired username: \n");
    username = sc.nextLine();

    System.out.println("Enter a desired password: \n");
    password = sc.nextLine();

    System.out.println("Thank you, please log in.\n");
    while (login) {
        checkvalid = false;
        System.out.println(" ------------------ \n" + "Username: \n");
        loginUser = sc.nextLine();
        System.out.println("Password: \n");
        loginPass = sc.nextLine();

        if (loginUser.equals(username) && (loginPass.equals(password))) {
            checkvalid = true;
            login = false;
            System.out.println("You have logged in.");
        } else {
            checkvalid = false;
            System.out.println("Incorrect username or password");
        }
    }
}