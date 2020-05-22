public static void main(String[] args)
{
  boolean done = false;
  Scanner console = new Scanner(System.in);
  while (!done)
  {
    String selection = displayMenu(console);
    done = processSelection(selection, console);
    System.out.println("");
  }
  System.out.println("Thank you for using this program");
}