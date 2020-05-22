import java.util.*;
class test{
 public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in); 
        System.out.println("Please input three numbers");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();
    int number [] = {num1,num2,num3};  //Sorting Array
    int temp;

    boolean correct = false; // Forces the sorting to continue till the numbers are in order

    while(correct ==false){
        correct = true;
    for(int i = 0; i<number.length-1; i++ ){

        if(number [i] >  number [i+1]){
            temp = number [i+1];
            number [i+1] = number[i];
            number[i]= temp;
            correct = false;

        }
    }
}
        for(int i = 0; i<number.length; i++){   //outputs the array to user
            System.out.println(number[i]);

        }

}}