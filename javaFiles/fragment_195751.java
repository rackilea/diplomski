import java.util.Scanner;
import cern.colt.Arrays;

public class Usage {
    public int[] vectorA, vectorB; public String value; 
    public String[] valueSplittedA, valueSplittedB;

    public void scan(){
        Scanner sc = new Scanner(System.in);
        value = sc.nextLine();
    }

    public void scanLine(){ //Get users values for vectors
        System.out.println("Enter the first Vector\n");
        scan();
        valueSplittedA = value.split(" ");
        vectorA = new int[valueSplittedA.length];
        System.out.println("Enter the second Vector\n");
        scan();
        valueSplittedB = value.split(" ");
        vectorB = new int[valueSplittedB.length];
        for(int i = 0; i<valueSplittedA.length; i++){
            String temp = valueSplittedA[i];
            vectorA[i] = Integer.parseInt(temp);
       }
        for(int i = 0; i<valueSplittedB.length; i++){
            String temp = valueSplittedB[i];
            vectorB[i] = Integer.parseInt(temp);
        }
        System.out.println(Arrays.toString(vectorA));
        System.out.println(Arrays.toString(vectorB));
    }

    public static void main(String[] args){
        Usage u = new Usage();
        u.scanLine();
    }