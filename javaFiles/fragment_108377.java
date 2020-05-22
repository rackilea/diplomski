import java.util.*;
class Money {
    public static void main(String[] args) {
        System.out.println("Enter values and type -1 to stop"); 
        System.out.println("'1' = Euros"); 
        System.out.println("'2' = Dollars"); 
        System.out.println("'3' = Yen"); 
        System.out.println("'4' = Rupees"); 
        System.out.println("'5' = Exit"); 
    int count=0;
    String exit = "-1", euro="E";

    Scanner scan = new Scanner(System.in);

    System.out.println();
    System.out.print("Convert to: ");

    while (!scan.hasNext("[E, D, Y, R, X]+")) {
        System.out.print("Invalid value, enter Surname again: ");
        scan.next();
    }

    String exTo = scan.next();

    ArrayList<String> num = new ArrayList<String>();

    while (true) {
        count++;
        System.out.print("|| Enter values "+count+" in (P)Pounds : ");

        while (!scan.hasNextDouble()) {
            System.out.print("Invalid value, try again: ");
            scan.next();
        }
        num.add(scan.next());

        if(num.contains(exit)){
            for(int i=0;i<num.size();i++){
            num.set(i,Integer.toString((Integer.parseInt(num.get(i))*2)));
            }
            System.out.println("Result: "+ num);

            scan.close();
            break;
        }
    }
}
}