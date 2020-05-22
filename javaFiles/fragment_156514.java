public class Application {
    public static void main(String[] args) {
        String correctPass = "Java";
        Scanner input = new Scanner(System.in);
        int num = 3;

        System.out.println("Enter the password"); 

        String line;
        while (num != 0 && !(line = input.nextLine()).equals(correctPass)) {

            System.out.println("Wrong password, please try again! "  + num + " attempts left!");
            num = num - 1;
            System.out.println("Enter the password");
        }

        if (num == 0) {
            System.out.println("System Locked!");
        } else {
            System.out.println("Wellcome back sir!");
        }
    }
}