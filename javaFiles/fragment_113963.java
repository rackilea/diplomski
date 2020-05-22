String input = sc.nextLine();
String[] temp = input.split(" ");
LinkedList<String> command = new LinkedList<String>(Arrays.asList(temp));

if(command.get(0).equalsIgnoreCase("shutdown") && command.size()==3) {
    Shutdown shutdown = new Shutdown();
    shutdown.Start(command);
}