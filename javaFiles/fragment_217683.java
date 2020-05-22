import java.util.Scanner;

public class Tset {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int [] a1 = new int[100];

        int i = 0;
        int tal;

        while(true){

            System.out.println("Insert number (0-end):");
            tal = scan.nextInt();

            if(tal == 0||i>=100){
                break;
            }else{
                a1[i]=tal;
                i++;
            }


        }//End of while


        System.out.println("The inserted numbers are are: ");
        for(int j=0;j<i;j++){
            System.out.println(a1[j]+"\t");

        }
        System.out.println("amount is: " +i);


    }//
}