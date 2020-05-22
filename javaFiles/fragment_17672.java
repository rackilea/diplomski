import java.util.Scanner;
public class Lab4 {

    public static void main(String[] args) {
        int i = 0;
        double [] numbers =new double[10];
        double sum =0;
        double sentValue=9999;
        int count = 0;
        System.out.println(numbers.length);
        System.out.print("Enter the numbers you want up to 20");
        Scanner input = new Scanner(System.in);
        while (i<numbers.length){
            double temp = input.nextDouble();
            if (temp >= sentValue){
                if(i==0){
                    System.out.println("Error Message Here");
                } else {
                    break;
                }
            }//if
            else {
                numbers[i] = temp;
                sum += numbers[i];
                i++;
                count++;
            }
        } //part of while loop*/

        //calculate average and distance from average
        double average=(sum/i);
        System.out.println("This is your average:" + average);

        for (i=0;i < count;i++){ //Display for loop
            double diffrence = (average-numbers[i]);
            System.out.println("This is how far number " +numbers[i] +" is from the average:" + diffrence);
        }//for loop
    }//main bracket

}//class lab4 bracket