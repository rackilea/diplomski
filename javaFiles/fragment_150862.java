Process proc = Runtime.getRuntime().exec(cmd)
// Start a stream gobbler to read the error stream.
StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream());
errorGobbler.start();

OutputStreamWriter osw = new OutputStreamWriter(proc.getOutputStream())
osw.write(mailBody)
osw.close();

int exitStatus = proc.waitFor();
if (0 != exitStatus) {
    /*
     * If you had not used a StreamGobbler to read the errorStream, you wouldn't have
     * had a chance to know what went wrong with this command execution.
     */
    LOG.warn("Error while sending email: " + errorGobbler.getContent());
}