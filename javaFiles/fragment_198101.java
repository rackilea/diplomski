import java.text.DecimalFormat;
import java.util.*;

public class CollinDunn_1_05 {

   DecimalFormat formatCash = new DecimalFormat("#,###.00");
   double iraTotal = 0.0;
   double saveAmount = 0.0;
   double totalSave = 0.0;
   double grossPay = 0.0;  // The gross pay from a users paycheck
   double saveRate = 0.0;  // This is the user entered savings rate
   double iraRate= 0.0;    // The IRA investment rate

    public CollinDunn_1_05(double gross, double saveRt, double iraRt){
      this.grossPay = gross;
      this.saveRate = saveRt;
      this.iraRate = iraRt;
    }

    public void calculate(){
      calcIraAmount();
      calcSavingsAmount();
    }

   public static void main (String [] args) {
      Scanner scanner = new Scanner(System.in);
      printInfo();                      

      CollinDunn_1_05 program = new CollinDunn_1_05(
          userInput("gross pay", scanner),
          userInput("savings rate", scanner),
          userInput("IRA rate", scanner)
        );

      program.calculate();
      program.outputResults();

   } // End Main

   public static void printInfo() {

     System.out.println ("This program uses methods to calculate \n"
                                           + "savings amounts and IRA investment amounts \n"
                                           + "from user input consisiting of their gross pay, \n"
                                           + "their desired savings rate and IRA rate, made by "
                                           + " Collin Dunn");
      return;

   } // End ProgramInfo

   public static double userInput(String whichOne, Scanner console) {
      double saveMe = 0.0;
      System.out.print("Please enter your " + whichOne + ":    ");
      saveMe = console.nextDouble(); 

      return saveMe;

   } // End userInput

    public void calcIraAmount() {    
      iraTotal = grossPay * (iraRate / 100.0);
   } // End iraAmount

   public void calcSavingsAmount() {       
      saveAmount = grossPay * (saveRate / 100.0);
   } // End savingsAmount


   public void outputResults() {
      totalSave = saveAmount + iraTotal;
      System.out.print ("With a gross pay of \$" + formatCash.format(grossPay)
                                         + ", a savings rate of %" + formatCash.format(saveRate)
                                         + " and a IRA rate of %" +formatCash.format(iraRate)
                                         + ".\n Your savings amount will be \$" + formatCash.format(saveAmount)
                                         + ", with a investment amount of \$" + formatCash.format(iraTotal)
                                         + ".\n Which leaves you with a total savings of \$" +
                                         +  totalSave + ". Way to go for paying yourself!" );

   } // End outputResults

} //End Class