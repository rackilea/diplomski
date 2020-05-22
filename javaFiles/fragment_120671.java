import java.util.Scanner;

public class estimateHeight {
private static Scanner kb = new Scanner(System.in);
private static Scanner kbNum = new Scanner(System.in);

public static boolean calculateHeight(char gender, float motherHeight, float fatherHeight ) {
    float height = 0;
    if(gender == 'm' || gender == 'M')
        height = ((motherHeight * 13/12) + fatherHeight )/2;
    else
        height = ((fatherHeight * 12/13) + motherHeight)/2;

    if(height <= 0) {
        System.out.println ("Invalid details. Please Re-enter. ");
       return true;
    }
    else{            
        System.out.println("The child's height is: " + height);
        return false;
    }
}

public static void main(String[] args) {
boolean check;
    do{
        System.out.println("Estimating the Adult Height of a Child. Press Q or -1 to quit.\n");
        String genderSelect;
        float fatherHeight, motherHeight;

        System.out.print("Gender? (m/f): ");
        genderSelect = kb.nextLine();
        if(genderSelect.equalsIgnoreCase("q"))
            System.exit(0);
        while(!(genderSelect.equalsIgnoreCase("m") || genderSelect.equalsIgnoreCase("f"))) {
            System.out.print("Invalid. Gender? (m/f): ");
            genderSelect = kb.nextLine();
        }

        System.out.print("Father's height? ");
        fatherHeight = kbNum.nextFloat();
        if(fatherHeight == -1)
            System.exit(0);

        System.out.print("Mother's height? ");
        motherHeight = kbNum.nextFloat();
        if(motherHeight == -1)
            System.exit(0);

        check = calculateHeight(genderSelect.charAt(0), motherHeight, fatherHeight);
    }while(check);
    }