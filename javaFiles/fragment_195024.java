String program = "eclipse.exe";   //or any other process
String listOfProcesses = getCommandOutput("tasklist");
 if (listOfProcesses == null || listOfProcesses.isEmpty()) {
        System.err.println("Unable to automatically determine if " + program + " is running");
    } else {
        if (listOfProcesses.contains(program)) {
            System.out.println(program + " is running!");
        } else {
            System.out.println(program + " is not running!");
        }
    }//else: process list can be retrieved