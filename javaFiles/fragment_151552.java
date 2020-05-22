public void execute(File file, String... command) {

    ProcessBuilder builder = new ProcessBuilder(command);
    builder.directory(file.getAbsoluteFile());
    builder.redirectErrorStream(true);

    try {
        Process p = builder.start();
    } catch (IOException e) {
        LOGGER.error("", e);
    }
}