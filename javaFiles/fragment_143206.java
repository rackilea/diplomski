import java.util.Scanner;
public class test1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many courses are you going to list?");
        int courses = Integer.parseInt(scan.nextLine());
        String courseArray[] = new String[courses];
        int creditArray[] = new int[courses];
        for (int i = 0; i < courseArray.length; i++){
            System.out.print("Please enter a course:");
            courseArray[i] = scan.nextLine();
            System.out.print("Please enter how many credits "+ courseArray[i] + " is:");
            String credits = scan.nextLine();
            int input = Integer.parseInt(credits);
            if (input >= 1 && input <= 4) {
                creditArray[i] = input;
            }
            else {
                creditArray[i] = 0;
            }
        }    int sum = 0;
        for (int i : creditArray){
            sum += i;
        }
        for (int i = 0; i < courseArray.length; i++) {
            System.out.print(courseArray[i] + " is a " + creditArray[i] + " credit class. \n");
        }
        print(sum);
    }
    public static void print(int sum){
        if(sum >= 12 && sum <= 18){
            System.out.println("You are taking " + sum + " total credits, which makes you a full time student.");
        }else if(sum < 12){
            System.out.println("You are taking " + sum + " total credits, which makes you not a full time student.");
        }else{
            System.out.println("You are taking " + sum + " total credits, which means you are overloaded");
        }
    }
}