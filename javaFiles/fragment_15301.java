//Initiates the process i'm about to start.
    ProcessBuilder pb = new ProcessBuilder(args);
    //Gets the system environment.
    Map<String, String> env = pb.environment();
    //Register VAR with value Value as an evironment variable in this process context
    env.put("VAR", "Value");
    //Stats the process initiated in the 1st line.
    pb.start();