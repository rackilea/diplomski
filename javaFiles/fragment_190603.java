import java.util.Scanner;

public class DoctorDoctor {

    public static void main (String [] args) {

        int idnumber;
        String name, field;

        Scanner sc = new Scanner(System.in);

        System.out.println("DOCTOR");

        /** Assuming ID number is an integer value */
        System.out.print("Enter ID Number: ");
        idnumber = sc.nextInt();
        sc.nextLine(); // This is important, for clearing the new line character

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Field of Specialization: ");
        field = sc.nextLine();

        System.out.println();
        System.out.printf("%-15s: %d%n", "ID Number", idnumber);
        System.out.printf("%-15s: %s%n", "Name", name);
        System.out.printf("%-15s: %s%n", "Specialization", field);

        sc.close();
    }
}