List<String> command = new ArrayList<>();
    command.add("mysql -u root -p ********");
    ProcessBuilder pb = new ProcessBuilder(command);
    Process process = pb.start();
    PrintStream commandIn = new PrintStream(process.getOutputStream());
    commandIn.println("select * from employee;");