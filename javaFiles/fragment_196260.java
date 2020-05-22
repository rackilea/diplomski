while(condition)
{
   int numberOfInput = getInput() ; //get the input from the user

   for(int i =0 ; i < numberOfInput; i++) //iterate for the amount of prompts required
     prompt() ; //get input

}



function prompt
      while (testScore1 < 1 || testScore1 > 100)
      {
        input = JOptionPane.showInputDialog("This test score is not " +
                "between 1 and 100. \nPlease enter a test score in " +
                "this range:");

        testScore1 = Double.parseDouble(input); 
      }