import java.util.Scanner;

public class ReadDouble {

    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        while(scan.hasNextLine()){
        String str = scan.nextLine();

        try {
            num = Double.parseDouble(str);
            System.out.println("Double number is " + num);
        } catch (NumberFormatException nfe) {
            System.out.println(str + " is not a Double number");
        }       
    }
}
}