import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class BookApplication {

    public static void main(String[] args) {
        try {
        System.out.println("Hi , Enter Your Name ?");
        Scanner scanner =new Scanner(System.in);
        String username= scanner.nextLine();
         String MY_OUTPUT_PATH="";//your  path where you want your file 
        boolean bookPurchased=true; // Do your code for bookpurchase
       if(bookPurchased){

           File receipt= new File(MY_OUTPUT_PATH+ File.separator+username+".txt");
           FileOutputStream outputStream =new FileOutputStream(receipt);

           String sampleData=username+" has purchased a book for rs.500";
           outputStream.write(sampleData.getBytes());
           outputStream.close();

       }
        } catch (Exception e) {
                System.out.println(e);
        }


       }

}