import java.util.Scanner;
import java.util.regex.Pattern;

public class GetDate {

   int month, day, year;

   public static void main(String[] args)
   {
      GetDate theApp = new GetDate();
      theApp.getDate();

   }

   public void getDate()
   {
      String date;
      do
      {
         System.out.print("Please enter your birth date (mm / dd / yyyy): ");
         Scanner in = new Scanner(System.in);
         date = in.nextLine();
      } while (validDate(date) == false);


      calcNum();
   }

   boolean validDate(String date)
   {
      // split the string based on white space
      String [] fields = date.split("\\s");

      // must have five fields
      if ( fields.length != 5 )
      {
         return false;
      }

      // must have '/' separators
      if ( ! ( fields[1].equals("/") && fields[3].equals("/") ) )
         return false;

      // must have integer strings
      if ( ! ( Pattern.matches("^\\d*$", fields[0]) && 
               Pattern.matches("^\\d*$", fields[2]) &&
               Pattern.matches("^\\d*$", fields[4]) ) )
         return false;

      // data was good, convert strings to integer 
      // should also check for integer within range at this point
      month = Integer.parseInt(fields[0]);
      day = Integer.parseInt(fields[2]);
      year = Integer.parseInt(fields[4]);

      return true;
   }

   void calcNum() {}
}