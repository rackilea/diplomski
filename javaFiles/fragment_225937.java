import java.util.Scanner;

class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Person person1 = new Person("Jon Snow", "London", 1);
        Person person2 = new Person("Arya Stark", "Edinburgh", 2);

        while(true) {
            System.out.print("Give a customer card number: ");
            String num = input.next();

            if (person1.isMatch(Integer.parseInt(num))) {
                System.out.println(person1);
            } else if (person2.isMatch(Integer.parseInt(num))) {
                System.out.println(person2);
            } else {
                System.out.println("Not found");
            }
        }
    }
}