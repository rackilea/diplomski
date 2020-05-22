public class Q2 {

    public static void main(String[] args) {
        String username;
        String password;
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        boolean authenticate;

        do {

            System.out.print("Please enter your username: ");
            username = keyboard.nextLine();

            System.out.print("Please enter your password: ");
            password = keyboard.nextLine();


           authenticate= !("johndoe".equals(username)) || !("secret1234".equals(password));


          System.out.println(authenticate?"Please Try again":"");

        } while(authenticate);

        System.out.print("You entered the system successfully.");
    }

}