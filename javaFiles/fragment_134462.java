private static String displayMenu(Scanner console)
{
  System.out.println("Enter one these options:");
  System.out.println("\tH for Help");
  System.out.println("\tU for using calculator");
  System.out.println("\tQ for exiting this program")
  System.out.print("Your selection: ");
  String selection = console.next();
  return selection;
}