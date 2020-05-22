import java.util.Scanner;
public class Assignment2{

    public static void main(String[] args){
        double sbp;
        double dbp;
        double map;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value of SBP(systolic blood pressure) ");
        sbp = sc.nextDouble();
        System.out.print("Enter the Value of DBP(diastolic blood pressure) ");
        dbp = sc.nextDouble();

        map = (sbp+2*dbp)/3;

        System.out.println("The MAP(mean arterial pressure) is::->>"+map+ "mm HG");

        if (map < 70.0)
            System.out.println(" Your MAP is considered LOW");
        else if (map > 110.0)
            System.out.println(" Your MAP is considered HIGH");
        else 
            System.out.println(" Your MAP is considered NORMAL");


    }

} // end class Assignment2