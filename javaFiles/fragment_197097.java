import java.util.Scanner;

public class information {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name ;
        String course;
        char gender;
        int yearLevel;
        int age;

        System.out.print("Enter your name: ");
        name  = input.nextLine();


        System.out.print("Enter your gender [M/F]: ");
        gender  = input.nextLine().charAt(0);

        while(gender!= 'M' && gender!= 'F'){
            System.out.println("Error: type only M or F");
            System.out.println("Re-enter your gender [M/F]: ");
            gender  = input.nextLine().charAt(0);
        }


        System.out.print("Enter your course: "); // BSCS, BSIT or BSIS
        course  = input.nextLine();

        while( course.equals("BSCS") || course.equals("BSIT") || course.equals("BSIS")){
            System.out.println("Error: type only BSCS,BSIT, or BSIS");
            System.out.println("Re-enter your course: ");
            course = input.nextLine();
        }

        System.out.print("Enter your year level: ");/// 1 to 4
        yearLevel  = input.nextInt();

        if(!(yearLevel<=4 && yearLevel>=1) )
        {
            System.out.print("you entered wrong year level(re-enter):");
            yearLevel  = input.nextInt();
        }

        System.out.print("Enter your age: ");
        age  = input.nextInt();

        while(!(age>=16) )
        {
            System.out.print("you entered wrong age(re-enter):");
            yearLevel  = input.nextInt();
        }
        System.out.println("");
        System.out.println("Student Information");
        System.out.printf("%s (%c)\n", name, gender);
        System.out.printf("%d years old\n", age);
        System.out.println(course + "-" + yearLevel);

        input.close();
    }

}