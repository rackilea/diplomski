boolean restart = true;
//Prompt for direction and miles
while(restart){    

boolean reprompt = true;
boolean reprompt_SecondQuestion=true;

while (reprompt) {

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
   while(reprompt_SecondQuestion)
   {
        numOfMiles = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter distance in miles: "));
        if (numOfMiles > 0) {
        totalMiles += numOfMiles;
        JOptionPane.showMessageDialog(null, "miles: " + totalMiles);
        reprompt_SecondQuestion = false;
   }
   else 
   {

   JOptionPane.showMessageDialog(null, error);
   }
  }

    //Prompt user to type "done"
    //Capture user input
    if(user_input.equals("Done"))
    {
       //Display direction and miles to user
       restart = false;
    }
    else
    {
    }
  }