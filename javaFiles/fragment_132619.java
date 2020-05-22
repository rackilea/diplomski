import java.util.Scanner;

     public class SalaryPay {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //declaration of fields
        double Level = 0;
        int SkillLevel;
        char Medical = 0;
        char Dental = 0;
        char Disability = 0;
        int hoursworked;
        double TotalPay = 0;
        double overPay = 0;
        double regPay = 0;
        char retirementplan = 0;
        double retire = (TotalPay*100) / 3;

        //enter Skill level
        System.out.println("Please press either 1 , 2, 3 according to your level");
        SkillLevel = sc.nextInt();

        switch(SkillLevel) { 
        case 1:
            Level = 19.00;
            break;
        case 2:
            Level = 23.00;
            break;
        case 3:
            Level = 27.00;
            break;
        }
        //Enter Hours worked
        System.out.println("Enter hours worked");
        hoursworked = sc.nextInt();
        /*modifed by raghu*/
        if (hoursworked >= 40) {
            regPay = 40 * Level;
            overPay = (hoursworked -40)  * (Level * 1.5);
        } else {
             regPay = hoursworked * Level;
        }
        TotalPay = regPay + overPay;
        //condition for Overtime
        /*if (hoursworked <= 40) {
            regPay = hoursworked * Level;
            overPay = 0;
        }
        else {
            regPay = hoursworked * Level;
            overPay = (hoursworked - 40) * Level * 1.5;  
            }*/


        //Insurance condition for skill 
        if(SkillLevel > 1) {
            System.out.println("Would you like to sign up for medical Insurance? (y/n)");
            Medical = sc.next().charAt(0);
            if (Medical == 'y') {
                TotalPay = TotalPay -  23.50; 
            }
            System.out.println("Would you like to sign up for Dental Insurance? (y/n)");
            Dental = sc.next().charAt(0);
            if (Dental == 'y') {
                TotalPay = TotalPay -  21.00; 
            }
            System.out.println("Would you like to sign up for Long-term Disability Insurance? (y/n)");
            Disability = sc.next().charAt(0);
            if (Disability == 'y') {
                TotalPay = TotalPay -  17.00; 
            }

        //Retirement plan condition
        if(SkillLevel == 3) {
            System.out.println("Do you want to participate in the retirement plan? (y/n):");
            retirementplan = sc.next().charAt(0);
            if (retirementplan == 'y') {
                TotalPay = TotalPay - retire;
            }
        }  // added by raghu

        //display results

            System.out.println("Hours worked this week : " + hoursworked
                            + "\nYour Hourly Pay Rate is : $" + Level
                            + "\nYour Payment is  : $" + regPay
                            + "\nYour Overtime Payment : $" + overPay);

                            if(Medical == 'y') {
                                System.out.println("Medical Insurance cost : -$23.50"); 
                            }
                            if(Dental == 'y') {
                                System.out.println("Dental Insurance cost : -$21.00");  
                            }
                            if(Disability == 'y') {
                                System.out.println("Long-term disability insurance cost : -$17.00");
                            }
                            if(retirementplan == 'y') {
                                System.out.println("Retirement Plan cost : -3%");
                            }
                            if(regPay < TotalPay) {
                                System.out.println("Error");
                            }
                            System.out.println("\nTotal earning after deduction : $" + TotalPay);
            //} --commented by raghu
        }
    }
}