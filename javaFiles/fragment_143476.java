import java.util.Scanner;

public class SumAverage {
static Scanner keyboard = new Scanner(System.in);

public static void main(String[] args) {

 int input,sum,avg,count;
 do{
    System.out.printf("Please enter number" + (count+1) + "%n");
    input = keyboard.nextInt()
    sum += input;
    count += 1;
    avg = sum/count;
 }while(input != 999);
 //Do whatever is to be done once sentinel is input.
}