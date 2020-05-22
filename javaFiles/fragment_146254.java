import javax.swing.JOptionPane;
public class taxiService {

public static void main(String [] args) {

//Declare constants
double fareCharge = 5;
double totalMiles = 0;
double finalFareCharged = 0;
double finalxCoord = 0;
double finalyCoord = 0;
double numOfMiles = 0;
double finalCoord = 0;
String error = "Invalid data, please enter valid data!";

String directions = "";
boolean reprompt = true;
//Prompt for direction and miles

while (reprompt) {
   totalMiles = numOfMiles + numOfMiles;
   directions = JOptionPane.showInputDialog(null, "Please enter a direction: ");
   if (directions.equalsIgnoreCase("East")) {
      finalxCoord = finalxCoord + numOfMiles;
      reprompt = false;
      }
      else if (directions.equalsIgnoreCase("West")) {
               finalxCoord = finalxCoord - numOfMiles;
               reprompt = false;
               }
             else if (directions.equalsIgnoreCase("North")) {
                     finalyCoord = finalyCoord + numOfMiles;
                     reprompt = false;
                     }
                     else if (directions.equalsIgnoreCase("South")) {
                             finalyCoord = finalyCoord - numOfMiles;
                             reprompt = false;
                             }
             else {
                 reprompt = true;
                 JOptionPane.showMessageDialog(null, error);

        }
   }
   numOfMiles = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter distance in miles: "));
   if (numOfMiles > 0) {
   JOptionPane.showMessageDialog(null, "miles: " + totalMiles);
   }else {
   JOptionPane.showMessageDialog(null, error);


   }
}
}