class Customer {
    static Scanner input = new Scanner(System.in);
    static String userName=null;
    static String password=null;
    public static void main(String[] args) {


        loginDetails("testtest", "testtest", "11111121111");
        System.out.print(logIn("ABC", "212"));
    }

    public static void customerInformation() {
//Create customerInformation
    }

    public static void loginDetails(String firstName, String lastName, String number) {

        userName = firstName.charAt(0) + lastName.substring(0, 3);
        password = lastName.substring(0, 3) + number.substring(7);

    }

    public static String logIn(String userName, String password) {
        int count = 0;
        while (count < 3) {
            System.out.print("Input Username");
            String inputUserName = input.nextLine();
            System.out.print("Input password");
            String inputPassword = input.nextLine();

            if (inputUserName.equals(userName) && inputPassword.equals(password)) {
                return "You are now logged in";
            } else {
                count++;
                if (count < 3)
                    System.out.println("Wrong Username or password. Try again");
            }
        } //While
        return "Try again in a few hours"; //Third try
    } //logIn
}