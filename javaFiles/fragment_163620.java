import java.util.Scanner;

public class MyMainProgram {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number to process");
        int num = in.nextInt();
        System.out.println("3x + 3 = " + MyLibrary.TriplePlusThree(num));

        String letters = "ABCDEFGHIJ";
        MyLibrary.MyRecord[] TenRecords = new MyLibrary.MyRecord[2];

        for (int i=0; i<TenRecords.length; i++){
            TenRecords[i] = new MyLibrary.MyRecord();
            TenRecords[i].number = i;
            TenRecords[i].letter = letters.charAt(i); 
        }

        // Printing class records
        for (int i=0; i<TenRecords.length; i++){
            System.out.println("Printing records of record " + i + " : ");
            System.out.println("Number : " + TenRecords[i].number);
            System.out.println("Letter : " + TenRecords[i].letter);
        }
        in.close();
    }
}