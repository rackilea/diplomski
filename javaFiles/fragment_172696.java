private static void executeProcess(Operation command, String database) throws IOException,
            InterruptedException {

        final File executorDirectory = new File("src/main/resources/");

private final static String shellScript = "./sparksubmit.sh";
ProcessBuilder processBuilder = new ProcessBuilder(shellScript, command.getOperation(), "argument-one");

        processBuilder.directory(executorDirectory);
          Process process = processBuilder.start();
          try {
            int shellExitStatus = process.waitFor();
            if (shellExitStatus != 0) {
                logger.info("Successfully executed the shell script");
            }
        } catch (InterruptedException ex) {
            logger.error("Shell Script process was interrupted");
        }
      }