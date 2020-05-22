public class CreditDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String n = keyboard.nextLine();
        System.out.print("Enter the age: ");
        int a = keyboard.nextInt();

        Person user = new Person(n, a);
        //how do I call findStatus to get the credit associated with the user?
        double credit = user.getCredit();
        System.out.println("Credit for " + user.getName() + " is: " + credit);
    }
}