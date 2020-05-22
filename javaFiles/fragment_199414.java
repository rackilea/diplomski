System.out.println("Enter a command from the list above (q to quit): ");
answer = scan.nextLine();
if (answer.equalsIgnoreCase("10") || answer.equalsIgnoreCase("q"))
    meow = false;
else
    cmd.command(answer);