public class GUI
{
  ...

  public void displayResults(Calcul results) 
  {
    SwingUtils.invokeLater(
      new Runnable()
      {
        public void run()
        {
          /* Some Swing actions. */
        }
      }
    );
  }
}