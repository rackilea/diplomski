private static void executeShellCommands(Connection connection, List<String> commandList) throws Exception {
    for(String command : commandList) {
        Session session = connection.openSession();
        InputStream stdout = new StreamGobbler(session.getStdout());
        session.requestDumbPTY();
        session.startShell();
        session.execCommand(command); 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stdout))) {
            String line = br.readLine() + "\n";
            StringBuilder shellOutput = new StringBuilder();
            while (line != null) {
                shellOutput.append(line);
                line = br.readLine() + "\n";
            }
        }
        session.close();
    }
}