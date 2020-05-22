if(answer == JOptionPane.YES_OPTION)
{

do {
   String gamelevel = (String) JOptionPane.showInputDialog
       (null,"please choose a difficulty level",
       "Choosing The Level", 
       JOptionPane.QUESTION_MESSAGE, null , 
       new Object[] {"Amazingly Hard!", 
       "Boringly Mediocre", "Shockingly Easy"},
       "Shockingly Easy");

       if(gamelevel==null)
       {
           JOptionPane.showMessageDialog(null, "Goodbye"); //CANCEL
       }
       else {
           Rungame(gamelevel);
       }
} while(playAgain());
}
else
{
   JOptionPane.showMessageDialog(null, "Goodbye"); //CANCEL
}