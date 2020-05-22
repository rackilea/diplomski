import java.util.ArrayList;
    import java.util.Scanner;

    public class pbclass {
        public static void main(String[] args) {
            pbclass objectt = new pbclass();
            objectt.dentistpractice();
        }

        Scanner scan = new Scanner(System.in);
         int array_length=10;
         int array_length2=0;
        String[] patientFamName = new String[array_length];
        String[] patientFirstName = new String[array_length];
        Integer[] PatientGoodTeeth = new Integer[array_length];
        Integer[] PatientBadTeeth = new Integer[array_length];



        public void dentistpractice() {


            for (int i = 0; i < array_length; ++i) {
                System.out.println("Enter surname name ");
                patientFamName[i] = scan.nextLine();
                if (patientFamName[i].equalsIgnoreCase("close")) {
                    break;
                }
                array_length2++;
                System.out.println("Enter first name ");
                patientFirstName[i] = scan.nextLine();
                System.out.println("Enter good teeth ");
                PatientGoodTeeth[i] = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter score for away team: ");
                PatientBadTeeth[i] = scan.nextInt();
                scan.nextLine();
            }
            for(int i = 0; i < array_length2; ++i){
                System.out.println("-----------------------");
                System.out.println(" | " +patientFamName[i] + " | "+ patientFirstName[i] + " | " + PatientGoodTeeth[i] + " | "+ PatientBadTeeth[i]+ " | ");
            }
            System.out.println("-----------------------");

        }
    }