Runnable helpHandler = new Runnable() {
    public void run(){
       // handle the command
    } 
}

// Define all your command handlers

HashMap<String, Runnable> commandsMap = new HashMap<>(); // Java 7 syntax

commandsMap.put("help",helpHandler);
// Add all your command handlers instances

String cmd; // read the user input
Runnable handler;
if((handler = commandsMap.get(cmd)) != null) {
  handler.run();
}