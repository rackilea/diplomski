import java.util.Scanner;

    public class Ovning_321 {
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            int number;
            int max = 0;
            int min = 0;

                  for (int x = 0; x<5; x++){ 
                        System.out.print("Give me an integer: "); 
                        number = input.nextInt(); 

                        if (x == 0 || number > max){ 
                            max = number;  
                        }               
                        if (x == 0 || number < min){ 
                            min = number;  
                        }               
                  }                 
                  System.out.println("Highest value: " + max);
                  System.out.println("Lowest value: " + min);
            }
     }