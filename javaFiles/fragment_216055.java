InputStream inStream = new FileInputStream(FileDescriptor.in);
    ConsoleReader reader = new ConsoleReader("App", inStream, System.out, null);

    reader.setPrompt("> ");

    reader.addCompleter(new FileNameCompleter());
    reader.addCompleter(new StringsCompleter(Arrays.asList(new String[] {
            "cmd1",
            "exit",
            "quit",
    })));

    String line;
    PrintWriter out = new PrintWriter(reader.getOutput());

    while ((line = reader.readLine()) != null) {
        if (line.startsWith("cmd1")) {
            String[] cmd = line.split("\\s+");
            if(cmd.length < 2) {
                out.println("Invalid command");
                help(out);
            } else {
                ... do work
            }
        } else if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
            break;
        } else {
            help(out);
        }
    }

    // ensure that all content is written to the screen at the end to make unit tests stable
    reader.flush();