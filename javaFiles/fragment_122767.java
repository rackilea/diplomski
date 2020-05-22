System.out.println("Please enter a line of integer values: ");
Scanner in = new Scanner(System.in);
if (in.hasNextLine())
{
    String line = in.nextLine();
    Scanner scan = new Scanner(line);
    while (scan.hasNextInt()) {
        myQueue.insert(scan.nextInt());
    }
}