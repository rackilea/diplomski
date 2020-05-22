public int runModule(OutputStream moduleOut, int argShowRange, List<String> arguments) throws IOException {

    int status = -1;
    Logger logger = Util.getOutputStreamLogger(moduleOut);
    logger.info("Starting module {}", getModuleName());

    ProcessBuilder exec = new ProcessBuilder();
    exec.directory(getWorkingDirectory());
    if (configureEnvironment(exec.environment(), moduleOut)) {

        List<String> command = getExecutable();
        command.addAll(arguments);
        exec.command(command);

        logger.info("With PYTHONPATH: {}", exec.environment().get("PYTHONPATH"));
        logger.info("In: {}", getWorkingDirectory());
        logger.info("Executing: {}", StringUtils.join(command, " "));
        Process proc = exec.start();

        try (InputStream procOut = proc.getInputStream(); InputStream procErrOut = proc.getErrorStream()) {
            copy(procOut, moduleOut);
            copy(procErrOut, moduleOut);
            LOGGER.debug("Waiting for process to finish");
            status = proc.waitFor();
            LOGGER.debug("Closing streams");
            procOut.close();
            procErrOut.close();
            logger.info("The process finished with exit code: {}", status);
        } catch (InterruptedException e) {
            LOGGER.warn("The thread was interrupted", e);
            Thread.currentThread().interrupt();
        }
    } else {
        logger.info("Module configuration failed");
    }
    Util.detachOutputStreamFromLogger(logger);

    return status;
}

public void copy(final InputStream in, final OutputStream out) throws IOException {
    executor.execute(() -> {
        try {
            byte[] buffer = new byte[4096];
            int n = 0;
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
        } catch (IOException e) {
            LOGGER.error("Ya done goofed", e);
        }
    });
}