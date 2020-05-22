ProcessBuilder processBuilder = new ProcessBuilder(command);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    String output = readOutput(process);
    try {
        if (process.waitFor() != 0) {
            throw new IOException(
                "command exited in error: " + process.exitValue()
                    + "\n" + output);
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return output;