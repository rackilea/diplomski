/**
     * This method is to spark submit
     * <pre> You can call spark-submit or mapreduce job on the fly like this.. by calling shell script... </pre>
     * @param commandToExecute String 
     */
    public static Boolean executeCommand(final String commandToExecute) {
        try {
            final Runtime rt = Runtime.getRuntime();
            // LOG.info("process command -- " + commandToExecute);
            final String[] arr = { "/bin/sh", "-c", commandToExecute};
            final Process proc = rt.exec(arr);
            // LOG.info("process started ");
            final int exitVal = proc.waitFor();
            LOG.trace(" commandToExecute exited with code: " + exitVal);
            proc.destroy();

        } catch (final Exception e) {
            LOG.error("Exception occurred while Launching process : " + e.getMessage());
            return Boolean.FALSE;
        }
             return Boolean.TRUE;
    }