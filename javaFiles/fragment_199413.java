else
{
    System.out.println("Illegal command");
    System.out.println("Enter a command from the list above (q to quit): ");
    answer = scan.nextLine();
    command(answer);
}