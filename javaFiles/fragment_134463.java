public static void main(String[] args)
{
    boolean done = false;
    Scanner console = new Scanner(System.in);
    while (!done){
        displayMenu();
        String selection = getUsersSelection(console);
        done = processSelection(selection, console);
        //caluculateResults(console);
    }
    System.out.println("Thank you for using this program");
}