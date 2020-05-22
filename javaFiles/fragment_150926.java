import java.util.Scanner;

public class Average {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("The program will calculate the average of the user inputted grades.");
        System.out.println("The program will start calculating with any negative integer");

        double sum = 0;
        int count = 0;
        double grade;

        do{
            System.out.print("Input grade (4-10): ");
            grade = scanner.nextDouble();

            if(grade >= 4 && grade <= 10){
                    sum = sum + grade;
                    count++;
            }else{
                System.out.println("Invalid grade!");
            }
        }while(grade >= 0);

        System.out.println(count + " grades were given.");
        System.out.println("Average: " + sum/count);


    }
}