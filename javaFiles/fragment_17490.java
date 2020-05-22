private String runCommand(String cmd, String[] params) {
        CommandLine commandLine = new CommandLine(cmd);
        commandLine.addArguments(params, false);
        ByteArrayOutputStream stdout = new ByteArrayOutputStream();
        ByteArrayOutputStream stderr = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(stdout, stderr);
        ExecuteWatchdog watchdog = new ExecuteWatchdog(30000);  // 30s timeout
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        executor.setWatchdog(watchdog);

        try {
            int retCode = executor.execute(commandLine);
            System.out.println("Executed '" + cmd + "'\n"
                    + "returnCode: " + retCode + "\n"
                    + "stdout:\n" + stdout.toString() + "\n"
                    + "stderr:\n" + stderr.toString());

            if (retCode == 0) {
                return stdout.toString();
            } else {
                throw new NonZeroExitStatusReturnedException(commandLine.toString(), retCode);
            }

        } catch (IOException e) {
            throw new RuntimeException("Could not run command "+ commandLine.toString(), e);
        }
}