import java.io.File;
import java.util.Scanner;

   public class ReadFile {

    public static void main(String[] args) {

        String dob="",name="";

        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the file name with extention : ");
            File file = new File(input.next());

            //get person name and dob to search for:
            System.out.print("Enter Person name : ");
            name = input.next();

            System.out.print("Enter Person DOB : ");
            dob = input.next();

            input = new Scanner(file);
            String newInput = input.nextLine();
            boolean found = false;

            while (input.hasNext()) {
                String line = input.next();
                String delims = "[:]"; 
                String[] tokens = line.split(delims);

                //check if this line matches target record
                if(tokens[0].equals(name) && tokens[1].equals(dob)){
                    System.out.println(String.format("Found Record, name: %s DOB: %s Nationality: %s",tokens[0],tokens[1],tokens[2]));
                    found=true;//mark as a record found
                    //no need to loop further
                    break;
                }
            }//while loop

            if(!found){
                System.out.println("No match records found!");
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("Error Occured ");
        }

    }

}