String fileToOpen = "test.pdf";
        List<String> command = new ArrayList<String>();
        command.add("rundll32.exe");
        command.add("url.dll,FileProtocolHandler");
        command.add(fileToOpen);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(new File("C://Software//"));
        builder.command(command);

        builder.start();